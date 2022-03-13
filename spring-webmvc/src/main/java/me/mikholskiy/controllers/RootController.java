package me.mikholskiy.controllers;

import jakarta.validation.Valid;
import me.mikholskiy.domains.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RootController {
	@GetMapping(value = "/")
	public String rootMapping() {
		return "index";
	}

	@GetMapping("/show-form")
	public String showForm(Model model) {
		model.addAttribute("student", new Student());
		return "form";
	}

	@GetMapping("/process-form")
	public String processForm(
			@Valid @ModelAttribute("student") Student student,
			BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "form";
		}
		return "student-confirmation";
	}
}
