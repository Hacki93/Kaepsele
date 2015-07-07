package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import learning.Medium;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MediumController {
	
	@RequestMapping (value = "/medium.htm", method = RequestMethod.GET)
	public String getForm(Model model) {
		Medium mediumModel = new Medium();
		model.addAttribute("medium", mediumModel);
		return "medium";
	}
	
	@RequestMapping (value = "/medium.htm", method = RequestMethod.POST)
	public String mediumHochladen(Model model, Medium medium, BindingResult result) {
		String ergebnisStatus = "erfolgmedium";
		
		if(result.hasErrors()){
			ergebnisStatus = "medium";
		}
		else{
			MultipartFile multipartMedium = medium.getFile();
			
			String orgName = multipartMedium.getOriginalFilename();
			String speicherort = "C:/Program Files/apache-tomcat-8.0.23/webapps/uploads/" + orgName;
			File desk = new File(speicherort);
			
			try{
				multipartMedium.transferTo(desk);
			}
			catch(IllegalStateException | IOException e){
				e.printStackTrace();
			}
		}
		return ergebnisStatus;
	}
	
	@RequestMapping(value = "/mediumrunterladen.htm", method = RequestMethod.GET)
	public @ResponseBody void mediumRunterladen(HttpServletRequest request, HttpServletResponse response) {
		ServletContext context = request.getServletContext();
		
		File ladeMedium = new File("C:/Program Files/apache-tomcat-8.0.23/webapps/uploads/Übungsblatt_2_Projektplan.pdf");
		FileInputStream inputStream = null;
		OutputStream outStream = null;
		
		try {
			inputStream = new FileInputStream(ladeMedium);
 
			response.setContentLength((int) ladeMedium.length());
			response.setContentType(context.getMimeType("C:/JavaHonk/CustomJar.jar"));			
 
			// response header
			String headerKey = "Content-Disposition";
			String headerValue = String.format("attachment; filename=\"%s\"",ladeMedium.getName());
			response.setHeader(headerKey, headerValue);
 
			// Write response
			outStream = response.getOutputStream();
			IOUtils.copy(inputStream, outStream);
		} 
		catch (Exception e) {
			e.printStackTrace();
		} 
		finally {
			try {
				if (null != inputStream)
					inputStream.close();
				if (null != inputStream)
					outStream.close();
			} 
			catch (IOException e) {
				e.printStackTrace();
			}
 
		}
	}
	
}