package me.mikholskiy.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameSyntaxConstraintViolation implements ConstraintValidator<NameSyntax, String> {
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return value == null || Character.isUpperCase(value.charAt(0));
	}
}
