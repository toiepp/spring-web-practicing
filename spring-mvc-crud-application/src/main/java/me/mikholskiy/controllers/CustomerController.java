package me.mikholskiy.controllers;

import com.github.tomaslanger.chalk.Chalk;
import me.mikholskiy.domains.Customer;
import me.mikholskiy.services.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

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
		if (customers.size() == 0) customers.addAll(customerService.getAll());

		return "customer/list";
	}

	@GetMapping("/customer-creation-form")
	public String showFormToCreateCustomer(@ModelAttribute("customer") Customer customer) {
		return "customer/form";
	}

	@GetMapping("/sort-customers-list")
	public String showSortedCustomersList(@ModelAttribute("list_of_customers") ArrayList<Customer> customers) {
		List<Customer> allCustomersSorted = customerService.getAll().stream()
			.sorted(Comparator.comparing(Customer::getFirstName))
			.toList();

		customers.addAll(allCustomersSorted);

		return "redirect:/customer/list";
	}

	@PostMapping("/new")
	public String addNewCustomer(@Valid @ModelAttribute("customer") Customer customer,
								 BindingResult bindingResult) {
		if (bindingResult.hasErrors()) return "customer/form";

		customerService.save(customer);

		return "redirect:/customer/list";
	}

	@GetMapping("/update/{customer-id}")
	public String showFormToUpdateCustomer(@PathVariable(value = "customer-id") String customerId,
										   @ModelAttribute("customer") Customer customerToUpdate) {
		System.out.println(Chalk.on("===[CustomerController::GET::/update/{id}]===: {{id=" +
			Chalk.on(customerId).yellow() + "}, " + Chalk.on(customerToUpdate.toString()).yellow() + "}").green());

		customerService.get(Integer.parseInt(customerId)).ifPresent(c -> {
			customerToUpdate.setId(c.getId());
			customerToUpdate.setFirstName(c.getFirstName());
			customerToUpdate.setLastName(c.getLastName());
			customerToUpdate.setEmail(c.getEmail());
		});

		System.out.println(Chalk.on("===[CustomerController::GET::/update/{id}]===: {{id=" +
			Chalk.on(customerId).yellow() + "}, " + Chalk.on(customerToUpdate.toString()).yellow() + "}").green());

		return "customer/update-form";
	}

	@PostMapping("/update")
	public String submitDataFromCustomerForm(@Valid @ModelAttribute("customer") Customer customer,
											 BindingResult bindingResult) {
		if (bindingResult.hasErrors()) return "customer/update-form";

		System.out.println(Chalk.on("===[CustomerController::POST::/update]===: {" + customer + "}").green());

		customerService.update(customer);

		return "redirect:/customer/list";
	}

	@GetMapping("/delete/{customer-id}")
	public String deleteCustomer(@PathVariable("customer-id") String customerId) {
		customerService.delete(Integer.parseInt(customerId));

		return "redirect:/customer/list";
	}
}
