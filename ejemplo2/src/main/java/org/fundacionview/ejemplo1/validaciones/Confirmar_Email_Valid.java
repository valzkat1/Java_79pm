package org.fundacionview.ejemplo1.validaciones;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.fundacionview.ejemplo1.modelos.Empleado;

public class Confirmar_Email_Valid implements ConstraintValidator<Confirmar_Email, Empleado>{

	@Override
	public boolean isValid(Empleado value, ConstraintValidatorContext context) {
		
		if(value.getEmail().equals(value.getConfirmarEmail())) {
			return true;
		}else {
		// TODO Auto-generated method stub
			context.buildConstraintViolationWithTemplate("Las direccinoes de email deben ser iguales")
			.addNode("confirmarEmail").addConstraintViolation();
			
		   return false;
		}
	}

}
