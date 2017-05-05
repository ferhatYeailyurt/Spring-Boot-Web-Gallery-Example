package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
}
