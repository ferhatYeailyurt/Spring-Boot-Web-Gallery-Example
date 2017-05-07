package springboot.controller;

import java.util.Date;

import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
	public String newPicture(HttpServletRequest request)
	{
		return "newPicture";
	}
	
	@GetMapping("/listPicture")
	public String allPicture(HttpServletRequest request)
	{
		request.setAttribute("pictures", pictureService.findAll());
		return "listPicture";
	}
	
	@PostMapping("/savePicture")
	public String savePicture(@ModelAttribute Picture picture, BindingResult bindingResult,HttpServletRequest request)
	{
		picture.setDateCreated(new Date());
		pictureService.save(picture);
		request.setAttribute("pictures", pictureService.findAll());
		return "newPicture";
	}
	
	
	
	
	
	
	
}
