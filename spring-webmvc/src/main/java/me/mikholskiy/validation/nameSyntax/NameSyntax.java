package me.mikholskiy.validation.nameSyntax;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.METHOD})
@Constraint(validatedBy = NameSyntaxConstraintValidator.class)
public @interface NameSyntax {
	String message() default "should start with upper letter";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}
