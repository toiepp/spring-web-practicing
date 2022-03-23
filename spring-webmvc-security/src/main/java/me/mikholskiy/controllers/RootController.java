package me.mikholskiy.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class RootController {
	@GetMapping
	public String root() {
		return "main";
	}

	@GetMapping("/show-my-login-page")
	public String showCustomLoginForm() {
		return "login-form";
	}

	@GetMapping("/leader")
	public String leaderAuthoritiesPage() {
		return "leaders-page";
	}

	@GetMapping("/system")
	public String systemAuthoritiesPage() {
		return "system-page";
	}

	@GetMapping("/access-denied")
	public String accessDenied() {
		return "forbidden-page";
	}
}
