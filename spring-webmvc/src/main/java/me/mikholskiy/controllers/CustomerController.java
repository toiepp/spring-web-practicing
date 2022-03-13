package me.mikholskiy.controllers;

import jakarta.validation.Valid;
import me.mikholskiy.domains.Customer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	@GetMapping("/form")
	public String customerForm(Model model) {
		model.addAttribute("customer", new Customer());
		return "customer/form";
	}

	@GetMapping("/confirmation")
	public String customerConfirmation(
			@ModelAttribute("customer") @Valid Customer customer,
			BindingResult bindingResult
	) {
		System.out.printf("\u001B[34m===Binding result: %s===\u001B[37m\n", bindingResult);

		if (bindingResult.hasErrors()) {
			return "customer/form";
		}


		customer.setFirstName(customer.getFirstName().toUpperCase());
		customer.setLastName(customer.getLastName().toUpperCase());

		return "customer/confirmation";
	}
}
