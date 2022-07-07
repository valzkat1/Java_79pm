package org.fundacionview.ejemplo1.validaciones;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = Indicativo_Colombia_Valid.class)
public @interface Indicativo_Colombia {

	public String value() default "";
	
	public String message() default "Solo Numeros con indicativo de pais Colombia.";
	
	public Class<?>[] groups() default { };
	
	public Class<? extends Payload>[] payload() default { };
	
	
	
}
