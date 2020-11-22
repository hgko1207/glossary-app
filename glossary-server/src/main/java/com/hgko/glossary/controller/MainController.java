package com.hgko.glossary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hgko.glossary.service.AbbreviationService;
import com.hgko.glossary.service.TermService;
import com.hgko.glossary.service.WordService;

@Controller
public class MainController {
	
	@Autowired
	private TermService termService;
	
	@Autowired
	private WordService wordService;
	
	@Autowired
	private AbbreviationService abbreviationService;

	@GetMapping("/")
    public String index(Model model) {
		 return "redirect:login";
    }
	
	@GetMapping("login")
    public String login(Model model, @RequestParam(value = "error", required = false) String error,
    		@CookieValue(value = "saved_username", defaultValue = "") String username) {
		if (error != null) {
			model.addAttribute("error", "falied");
		}
		
		if (username != null) {
			model.addAttribute("username", username);
		}
        return "login";
    }
	
	/**
	 * 대시보드 화면
	 * @param model
	 */
	@GetMapping("home")
	public void home(Model model) {
		model.addAttribute("terms", termService.getList().size());
		model.addAttribute("words", wordService.getList().size());
		model.addAttribute("abbrs", abbreviationService.getList().size());
	}
}
