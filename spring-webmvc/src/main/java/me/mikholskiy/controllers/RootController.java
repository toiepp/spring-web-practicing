package me.mikholskiy.controllers;

import me.mikholskiy.domains.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RootController {
	private final String param = "Ivan";

	@GetMapping
	public String rootMapping() {
		return "index";
	}

	@GetMapping(value = "/show-form")
	public String showForm(@ModelAttribute("student") Student student) {
		return "form";
	}

	@GetMapping(value = "/process-form", params = "firstName=" + param)
	public String processForm(@ModelAttribute("student") Student student) {
		return "student-confirmation";
	}
}
