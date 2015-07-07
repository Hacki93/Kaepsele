package controller;

import learning.Medium;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class MediumValidator implements Validator { 

	public boolean supports(Class<?> paramClass) { 
		return Medium.class.equals(paramClass); 
	} 

	public void validate(Object obj, Errors errors) { 
		Medium file = (Medium) obj; 
		if (file.getFile().getSize() == 0) { 
			errors.rejectValue("file", "valid.file"); 
		} 
	} 

} 