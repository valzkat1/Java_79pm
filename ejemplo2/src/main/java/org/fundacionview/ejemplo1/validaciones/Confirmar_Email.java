package org.fundacionview.ejemplo1.validaciones;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.fundacionview.ejemplo1.modelos.*;


@Retention(RUNTIME)
@Target(TYPE)
@Constraint(validatedBy = Confirmar_Email_Valid.class)
public @interface Confirmar_Email {

	public String value() default "";
	
	public String message() default "Los campos Email y ConfirmarEmail deben Coincidir";
	
	public Class<?>[] groups() default {};
	
	public Class<? extends Payload>[] payload() default {};
	
	
}
