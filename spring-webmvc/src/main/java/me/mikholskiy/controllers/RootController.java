package me.mikholskiy.controllers;

import me.mikholskiy.domains.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RootController {
	@GetMapping
	public String rootMapping() {
		return "index";
	}

	@GetMapping("/show-form")
	public String showForm(@ModelAttribute("student") Student student) {
		return "form";
	}

	@GetMapping("/process-form")
	public String processForm(@ModelAttribute("student") Student student) {
		return "student-confirmation";
	}
}
