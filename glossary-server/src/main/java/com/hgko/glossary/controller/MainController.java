package com.hgko.glossary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping("/")
    public String index(Model model) {
		 return "redirect:home";
    }
	
	@GetMapping("home")
	public void home(Model model) {
	}
}
