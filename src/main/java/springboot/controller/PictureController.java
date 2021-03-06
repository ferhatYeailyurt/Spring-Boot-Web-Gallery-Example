package springboot.controller;


import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Date;
import java.util.List;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.RequestContext;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import ch.qos.logback.classic.pattern.FileOfCallerConverter;
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
	
		
	@GetMapping("/yazdir")
	public String displayPicture(HttpServletRequest request,HttpServletResponse response) throws IOException
	{
		
		
		response.setContentType("image/jpeg");
		
		ServletOutputStream out;
		out = response.getOutputStream();
		String path = request.getParameter("path");
		
		System.out.println(request.getParameterValues(path));
		FileInputStream fin = new FileInputStream("c:\\Users\\ferhat\\workspaceneonk\\springboot\\src\\main\\webapp\\images\\"+path);
		
		System.out.println("yeni yol:"+fin);
		
		BufferedInputStream bin = new BufferedInputStream(fin);
		BufferedOutputStream bout = new BufferedOutputStream(out);
		int ch =0; ;
		while((ch=bin.read())!=-1)
		{
		bout.write(ch);
		}
		
		bin.close();
		fin.close();
		bout.close();
		out.close();
		
	    return "listPicture";
	}
	
	
	
	
	
	
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public @ResponseBody
	String uploadFileHandler(@ModelAttribute Picture picture, BindingResult bindingResult, @RequestParam("pictureName") String name, @RequestParam("file") MultipartFile file,HttpServletRequest request) {

		
		
		File serverFile = null;
		if (!file.isEmpty()) {
			try {
				byte[] bytes = file.getBytes();

				// Creating the directory to store file
				String rootPath = "c:\\Users\\ferhat\\workspaceneonk\\springboot\\src\\main\\webapp\\images";
				File dir = new File(rootPath);
				if (!dir.exists())
					dir.mkdirs();

				// Create the file on server
				serverFile = new File(dir.getAbsolutePath()
						+ File.separator + name+".jpg");
				String str=serverFile.getAbsolutePath();
				System.out.println("yol:"+str);
				BufferedOutputStream stream = new BufferedOutputStream(
						new FileOutputStream(serverFile));
				stream.write(bytes);
				stream.close();
				
				
				//////
				picture.setDateCreated(new Date());
				
				
				File dosya = new File(str);
				
				
				SecureRandom random = new SecureRandom();
				
				String uniq = new BigInteger(130,random).toString();
				
				String absolutePath = dosya.getAbsolutePath();
				
				String filePath = absolutePath.
				    substring(0,absolutePath.lastIndexOf(File.separator));
				
				File newFile = new File(absolutePath+uniq+dosya.getName());
				
			
				dosya.renameTo(newFile);
				dosya.delete();
				
				picture.setImagePath(newFile.getName());

				pictureService.save(picture);
				request.setAttribute("pictures", pictureService.findAll());
				
							return "Başarılı";
						} catch (Exception e) {
							return "You failed to upload " + name + " => " + e.getMessage();
						}
					} else {
						System.out.println("You failed to upload " + name
								+ " because the file was empty."); 
					}
			
			return "listPicture";
		
	}

	
		
	
}

	
	
	
	
	
	
	

