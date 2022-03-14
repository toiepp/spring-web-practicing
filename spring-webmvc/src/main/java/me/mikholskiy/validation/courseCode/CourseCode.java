package me.mikholskiy.validation.courseCode;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Target({FIELD, METHOD})
@Constraint(validatedBy = CourseCodeConstraintValidator.class)
public @interface CourseCode {
	String defaultValue = "MEN";

	// define course code
	String value() default defaultValue;

	// define error message
	String message() default "must start with " + defaultValue;

	// define default groups
	// Groups: can group related constraints
	Class<?>[] groups() default {};

	// define default payloads
	// Payloads: provide custom details about validation failure (severity level, error code etc)
	Class<? extends Payload>[] payload() default {};
}
