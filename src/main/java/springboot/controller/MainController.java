package springboot.controller;







import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import springboot.model.Picture;
import springboot.service.PictureService;

@Controller
public class MainController {
	
	@Autowired
	private PictureService pictureService;

	@GetMapping("/home")
	public String home()
	{
		return "index";
	}
	
	@GetMapping("/save-picture")
	public String savePicture(@RequestParam String name,@RequestParam String description )
	{
		Picture picture=new Picture(name, description, new Date());
		pictureService.save(picture);
		return "picture saved";
	}
	
	
}
