package me.mikholskiy.controllers;

import me.mikholskiy.domains.Student;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/student")
public class StudentController {
	@GetMapping(value = "/form")
	public String showForm(@ModelAttribute("student") Student student) {
		return "form";
	}

	@GetMapping(value = "/confirmation")
	public String processForm(@ModelAttribute("student") Student student) {
		return "student-confirmation";
	}
}
