package com.hgko.glossary.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 약어 관리 컨트롤러
 * 
 * @author hgko
 *
 */
@Controller
@RequestMapping("abbr")
public class AbbreviationController {

	/**
	 * 목록 화면
	 * @param model
	 */
	@GetMapping("list")
    public void list(Model model) {
    }
}
