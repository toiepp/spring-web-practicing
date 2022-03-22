package me.mikholskiy.controllers;

import me.mikholskiy.domains.Customer;
import me.mikholskiy.exceptions.CustomerNotFoundException;
import me.mikholskiy.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Comparator;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	private Service<Customer> customerService;

	@InitBinder
	public void init(WebDataBinder dataBinder) {
		dataBinder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}

	@Autowired
	public void setService(Service<Customer> service) {
		this.customerService = service;
	}

	@GetMapping
	public String root() {
		return "customer/root-page";
	}

	@GetMapping("/list")
	public String customerList(@ModelAttribute("list_of_customers") ArrayList<Customer> customers) {
		customers.addAll(customerService.getAll().stream().sorted(Comparator.comparing(Customer::getLastName)).toList());

		return "customer/list";
	}

	@GetMapping("/customer-creation-form")
	public String showFormToCreateCustomer(@ModelAttribute("customer") Customer customer) {
		return "customer/form";
	}

	@PostMapping("/new")
	public String addNewCustomer(@Valid @ModelAttribute("customer") Customer customer,
								 BindingResult bindingResult) {
		if (bindingResult.hasErrors()) return "customer/form";

		customerService.save(customer);
		System.out.println(customer);

		return "redirect:/customer/list";
	}

	@GetMapping("/update")
	public String showFormToUpdate(@RequestParam(value = "customer-id") Integer customerId, Model model) {
		try {
			model.addAttribute("customer", customerService.get(customerId).orElse(new Customer()));
		} catch (CustomerNotFoundException e) {
			return "redirect:/customer/list";
		}

		return "customer/form";
	}

	@PostMapping("/update")
	public String submitDataFromCustomerForm(@Valid @ModelAttribute("customer") Customer customer,
											 BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "customer/form";
		}

		customerService.update(customer);

		return "redirect:/customer/list";
	}

	@GetMapping("/delete/{customer-id}")
	public String deleteCustomer(@PathVariable("customer-id") String customerId) {
		customerService.delete(Integer.parseInt(customerId));

		return "redirect:/customer/list";
	}

	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customer-id") Integer customerId) {
		customerService.delete(customerId);

		return "redirect:/customer/list";
	}
}
