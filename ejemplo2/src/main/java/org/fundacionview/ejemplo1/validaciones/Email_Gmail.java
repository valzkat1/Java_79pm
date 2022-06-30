package org.fundacionview.ejemplo1.validaciones;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target(ElementType.FIELD)
@Constraint(validatedBy = Email_Gmail_Valid.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface Email_Gmail {

	public String value() default "";
	
	public String message() default "Solo direcciones de correo de gmail.";
	
	public Class<?>[] groups() default { };

	public Class<? extends Payload>[] payload() default { };
	
	
}
