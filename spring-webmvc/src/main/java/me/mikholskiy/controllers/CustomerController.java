package me.mikholskiy.controllers;

import me.mikholskiy.domains.Customer;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Calendar;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@GetMapping("/form")
	public String customerForm(@ModelAttribute("customer") Customer model) {
		return "customer/form";
	}

	@GetMapping(value = "/confirmation")
	public String customerConfirmation(
			@ModelAttribute("customer") @Valid Customer customer,
			BindingResult bindingResult
	) {
		System.out.printf("\u001b[34m[%s] %s\u001b[39m\n", Calendar.getInstance().getTime(), bindingResult);

		return "customer/%s".formatted(
				(bindingResult.hasErrors()) ? "form" : "confirmation"
		);
	}
}
