package org.hohenheim;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;


@Controller  
public class FileController { 

	@Autowired 
	FileValidator validator; 

	@InitBinder 
	private void initBinder(WebDataBinder binder) { 
		binder.setValidator(validator); 
	} 

	@RequestMapping(value = "/file.htm", method = RequestMethod.GET) 
	public String getForm(Model model) { 
		FileTest fileModel = new FileTest(); 
		model.addAttribute("file", fileModel); 
		return "file"; 
	} 

	@RequestMapping(value = "/file.htm", method = RequestMethod.POST) 
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
	
	@RequestMapping(value = "/filedownload.htm", method = RequestMethod.GET)
	public @ResponseBody void downloadFiles(HttpServletRequest request, HttpServletResponse response) {
 
		ServletContext context = request.getServletContext();
		
		File downloadFile = new File("C:/Program Files/apache-tomcat-8.0.23/webapps/uploads/Übungsblatt_2_Projektplan.pdf");
		FileInputStream inputStream = null;
		OutputStream outStream = null;
		
		try {
			inputStream = new FileInputStream(downloadFile);
 
			response.setContentLength((int) downloadFile.length());
			response.setContentType(context.getMimeType("C:/JavaHonk/CustomJar.jar"));			
 
			// response header
			String headerKey = "Content-Disposition";
			String headerValue = String.format("attachment; filename=\"%s\"",downloadFile.getName());
			response.setHeader(headerKey, headerValue);
 
			// Write response
			outStream = response.getOutputStream();
			IOUtils.copy(inputStream, outStream);
 
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (null != inputStream)
					inputStream.close();
				if (null != inputStream)
					outStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
 
		}
 
	}


} 

