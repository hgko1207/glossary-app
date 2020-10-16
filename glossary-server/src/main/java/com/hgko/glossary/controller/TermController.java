package com.hgko.glossary.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hgko.glossary.domain.db.Word;

@Controller
@RequestMapping("term")
public class TermController {

	@GetMapping("list")
	public ResponseEntity<?> list() {
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping("regist")
	public ResponseEntity<?> regist(Word word) {
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
