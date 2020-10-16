package com.hgko.glossary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hgko.glossary.domain.db.Word;
import com.hgko.glossary.domain.param.SearchParam;
import com.hgko.glossary.service.WordService;

/**
 * 단어 관리 컨트롤러
 * 
 * @author hgko
 *
 */
@Controller
@RequestMapping("word")
public class WordController {
	
	@Autowired
	private WordService wordService;

	@GetMapping("list")
	public ResponseEntity<?> list(SearchParam param) {
		return new ResponseEntity<>(wordService.getList(param), HttpStatus.OK);
	}
	
	@PostMapping("regist")
	public ResponseEntity<?> regist(Word word) {
		if (wordService.regist(word)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
	}
	
	@PutMapping("update")
	public ResponseEntity<?> update(Word word) {
		if (wordService.update(word)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
	}
	
	@DeleteMapping("delete")
	public ResponseEntity<?> delete(Word word) {
		if (wordService.delete(word.getId())) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_GATEWAY);
	}
}
