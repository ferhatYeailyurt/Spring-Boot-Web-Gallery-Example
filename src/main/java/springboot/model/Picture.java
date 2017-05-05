package springboot.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Type(type="timestamp")
	private Date dateCreated;

	public Picture(String pictureName, String pictureDescription, Date dateCreated) {
		super();
		this.pictureName = pictureName;
		this.pictureDescription = pictureDescription;
		this.dateCreated = dateCreated;
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
