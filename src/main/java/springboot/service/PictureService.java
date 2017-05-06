package springboot.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import springboot.dao.PictureRepository;
import springboot.model.Picture;

@Service
@Transactional
public class PictureService {
	
	private final PictureRepository pictureRepository;

	public PictureService(PictureRepository pictureRepository) {
		this.pictureRepository = pictureRepository;
	}
	
	public List<Picture> findAll()
	{
		List<Picture> pictures=new ArrayList<>();
		
		for(Picture picture : pictureRepository.findAll())
		{
			pictures.add(picture);
		}
		return pictures;
	}
	
	public void save(Picture picture)
	{
		pictureRepository.save(picture);
	}
	
	public void delete(int id)
	{
		pictureRepository.delete(id);
	}
	
}
