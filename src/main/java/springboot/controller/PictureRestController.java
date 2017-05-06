package springboot.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import springboot.model.Picture;
import springboot.service.PictureService;

@RestController
public class PictureRestController {
	
	@Autowired
	private PictureService pictureService;

	
	@GetMapping("/test")
	public String test()
	{
		return "test basarili v1";
	}
	
	@GetMapping("/all-pictures")
	public String allPictures()
	{
		return pictureService.findAll().toString();
	}
	
	@GetMapping("/save-picture")
	public String savePicture(@RequestParam String name,@RequestParam String description )
	{
		Picture picture=new Picture(name, description, new Date());
		pictureService.save(picture);
		return "picture saved";
	}
	
	@GetMapping("/delete-picture")
	public String deletePicture(@RequestParam int id )
	{		
		pictureService.delete(id);
		return "delete picture";
	}
}
