package me.mikholskiy.validation.nameSyntax;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class NameSyntaxConstraintValidator implements ConstraintValidator<NameSyntax, String> {
	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {
		return Character.isUpperCase(value.charAt(0));
	}
}
