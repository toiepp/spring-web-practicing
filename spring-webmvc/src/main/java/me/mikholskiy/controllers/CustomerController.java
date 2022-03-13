package me.mikholskiy.controllers;

import me.mikholskiy.domains.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@GetMapping("/form")
	public String customerForm(@ModelAttribute("customer") Customer model) {
		return "customer/form";
	}

	@GetMapping("/confirmation")
	public String customerConfirmation(
			@ModelAttribute("customer") @Valid Customer customer,
			BindingResult bindingResult) {
		return "customer/%s".formatted(
				(bindingResult.hasErrors()) ? "form" : "confirmation"
		);
	}
}
