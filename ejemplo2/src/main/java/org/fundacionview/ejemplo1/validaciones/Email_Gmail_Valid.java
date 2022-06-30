package org.fundacionview.ejemplo1.validaciones;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Email_Gmail_Valid implements ConstraintValidator<Email_Gmail, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		// TODO Auto-generated method stub
		if(value.endsWith("@gmail.com")) {
			return true;
		}else
		
		return false;
	}

}
