package me.mikholskiy.controllers;

import com.github.tomaslanger.chalk.Chalk;
import me.mikholskiy.domains.Customer;
import me.mikholskiy.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

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
		if (customers.isEmpty()) {
			customers.addAll(customerService.getAll());
		} else {
			customers.forEach(System.out::println);
		}

		return "customer/list";
	}

	@GetMapping("/customer-creation-form")
	public String showFormToCreateCustomer(@ModelAttribute("customer") Customer customer) {
		return "customer/form";
	}

	@GetMapping("/list/sort")
	public ModelAndView showSortedCustomersList(@ModelAttribute("list_of_customers") ArrayList<Customer> customers) {
		List<Customer> allCustomersSorted = customerService.getAll().stream()
			.sorted(Comparator.comparing(Customer::getFirstName))
			.toList();

		customers.addAll(allCustomersSorted);

		return new ModelAndView("redirect:/customer/list",
			new ModelMap("list_of_customers", customers));
	}

	@PostMapping("/new")
	public String addNewCustomer(@Valid @ModelAttribute("customer") Customer customer,
								 BindingResult bindingResult) {
		if (bindingResult.hasErrors()) return "customer/form";

		customerService.save(customer);

		return "redirect:/customer/list";
	}

	@GetMapping("/update")
	public String showFormToUpdate(@RequestParam(value = "customer-id") Integer customerId, Model model) {
		model.addAttribute("customer", customerService.get(customerId).orElse(new Customer()));

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
