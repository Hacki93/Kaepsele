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
public class MediumController {

	@Autowired 
	MediumValidator validator; 

	@InitBinder 
	private void initBinder(WebDataBinder binder) { 
		binder.setValidator(validator); 
	} 
	
//	@RequestMapping (value = "/medium", method = RequestMethod.GET)
//	public String getForm(Model model) {
//		Medium mediumModel = new Medium();
//		model.addAttribute("medium", mediumModel);
//		return "medium";
//	}
//	
//	@RequestMapping (value = "/medium", method = RequestMethod.POST)
//	public String mediumHochladen(Model model, @Validated Medium medium, BindingResult result, HttpServletRequest request) {
//		String ergebnisStatus = "erfolgmedium";
//		
//		if(result.hasErrors()){
//			ergebnisStatus = "medium";
//		}
//		else{
//			MultipartFile multipartMedium = medium.getFile();
//			
//			ServletContext context = request.getServletContext();
//	        String projektPfad = context.getRealPath("");
//	        String [] pfad = projektPfad.split("Kaepsele");
//			String orgName = multipartMedium.getOriginalFilename();
//			String speicherort = pfad[0] + "/Kaepsele/SoftwarePraktikum/Klausuren/" + orgName;
//			File desk = new File(speicherort);
//			
//			try{
//				multipartMedium.transferTo(desk);
//			}
//			catch(IllegalStateException | IOException e){
//				e.printStackTrace();
//			}
//		}
//		return ergebnisStatus;
//	}
//	
//	@RequestMapping(value = "/mediumrunterladen", method = RequestMethod.GET)
//	public @ResponseBody void mediumRunterladen(HttpServletRequest request, HttpServletResponse response) {
//		
//		// get absolute path of the application
//		ServletContext context = request.getServletContext();
//        String projektPfad = context.getRealPath("");
//        String [] pfad = projektPfad.split("Kaepsele");
//        String mediumPfad = pfad[0] + "/Kaepsele/SoftwarePraktikum/Klausuren/Entwurf.pdf";
//
//		File ladeMedium = new File(mediumPfad);
//		FileInputStream inputStream = null;
//		OutputStream outStream = null;
//		
//		try {
//			inputStream = new FileInputStream(ladeMedium);
// 
//			response.setContentLength((int) ladeMedium.length());
//			response.setContentType(context.getMimeType("C:/JavaHonk/CustomJar.jar"));			
// 
//			// response header
//			String headerKey = "Content-Disposition";
//			String headerValue = String.format("attachment; filename=\"%s\"",ladeMedium.getName());
//			response.setHeader(headerKey, headerValue);
// 
//			// Write response
//			outStream = response.getOutputStream();
//			IOUtils.copy(inputStream, outStream);
//		} 
//		catch (Exception e) {
//			e.printStackTrace();
//		} 
//		finally {
//			try {
//				if (null != inputStream)
//					inputStream.close();
//				if (null != inputStream)
//					outStream.close();
//			} 
//			catch (IOException e) {
//				e.printStackTrace();
//			}
// 
//		}
//	}
	
}