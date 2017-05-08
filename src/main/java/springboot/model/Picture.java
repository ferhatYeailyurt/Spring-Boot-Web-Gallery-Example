package springboot.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.Type;

@Entity(name="my_db")
public class Picture implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	private String pictureName;

	private String pictureDescription;
	
	@Basic
    @Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;
	
	private String imagePath;
	
	
	
	public String getImagePath() {
		return imagePath;
	}

	public Picture(String pictureName, String pictureDescription, Date dateCreated, String imagePath) {
		super();
		this.pictureName = pictureName;
		this.pictureDescription = pictureDescription;
		this.dateCreated = dateCreated;
		this.imagePath = imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public Picture() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPictureName() {
		return pictureName;
	}

	public void setPictureName(String pictureName) {
		this.pictureName = pictureName;
	}

	public String getPictureDescription() {
		return pictureDescription;
	}

	public void setPictureDescription(String pictureDescription) {
		this.pictureDescription = pictureDescription;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	@Override
	public String toString() {
		return "Picture [id=" + id + ", pictureName=" + pictureName + ", pictureDescription=" + pictureDescription
				+ ", dateCreated=" + dateCreated + "]";
	}
	
	

}
