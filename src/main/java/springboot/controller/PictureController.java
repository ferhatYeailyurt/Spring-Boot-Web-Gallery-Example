package springboot.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springboot.model.Picture;
import springboot.service.PictureService;

@Controller
public class PictureController {
	
	@Autowired
	private PictureService pictureService;

	@GetMapping("/")
	public String home()
	{
		return "index";
	}
	
	@GetMapping("/newPicture")
	public String newPicture()
	{
		return "newPicture";
	}
	
	
	
	
	
	
	
}
