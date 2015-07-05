package org.hohenheim;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;


@Controller  
@RequestMapping("/file.htm")  
public class FileController { 

	@Autowired 
	FileValidator validator; 

	@InitBinder 
	private void initBinder(WebDataBinder binder) { 
		binder.setValidator(validator); 
	} 

	@RequestMapping(method = RequestMethod.GET) 
	public String getForm(Model model) { 
		FileTest fileModel = new FileTest(); 
		model.addAttribute("file", fileModel); 
		return "file"; 
	} 

	@RequestMapping(method = RequestMethod.POST) 
	public String fileUploaded(Model model, @Validated FileTest file, BindingResult result) { 
		String returnVal = "successFile"; 
		
		
		if (result.hasErrors()) { 
			returnVal = "file"; 
		} else {             
			MultipartFile multipartFile = file.getFile();
			
			String orgName = multipartFile.getOriginalFilename();
			String filePath = "C:/Program Files/apache-tomcat-8.0.23/webapps/uploads/" + orgName;
			File dest = new File(filePath);
			
			try {
				multipartFile.transferTo(dest);
			} catch (IllegalStateException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		} 
		return returnVal; 
	} 

} 

