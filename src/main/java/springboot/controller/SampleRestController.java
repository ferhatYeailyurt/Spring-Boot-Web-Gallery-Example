package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import springboot.service.PictureService;

@RestController
public class SampleRestController {
	
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
}
