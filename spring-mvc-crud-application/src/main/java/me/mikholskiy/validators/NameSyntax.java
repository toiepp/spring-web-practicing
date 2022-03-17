package me.mikholskiy.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = NameSyntaxConstraintViolation.class)
public @interface NameSyntax {
	String message() default "name must starts with capital letter";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
