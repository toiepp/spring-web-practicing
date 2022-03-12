package me.mikholskiy.controllers;

import me.mikholskiy.domains.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller("/")
public class RootController {
	@GetMapping(value = "/")
	public String rootMapping() {
		return "redirect:/show-form";
	}

	@GetMapping("/show-form")
	public String showForm(Model model) {
		model.addAttribute("student", new Student());
		return "helloworld-form";
	}

	@GetMapping("/process-form")
	public String processForm(@ModelAttribute("student") Student student) {
		System.out.println(student);
		return "student-confirmation";
	}
}
