package org.hohenheim;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class FileValidator implements Validator { 

	public boolean supports(Class<?> paramClass) { 
		return FileTest.class.equals(paramClass); 
	} 

	public void validate(Object obj, Errors errors) { 
		FileTest file = (FileTest) obj; 
		if (file.getFile().getSize() == 0) { 
			errors.rejectValue("file", "valid.file"); 
		} 
	} 

} 

