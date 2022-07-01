package org.fundacionview.ejemplo1.validaciones;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Indicativo_Colombia_Valid implements ConstraintValidator<Indicativo_Colombia, String>{

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		
		if(value.startsWith("+57-")) {
			return true;
		}else {
			return false;
		}
		
		// TODO Auto-generated method stub
		
	}

}
