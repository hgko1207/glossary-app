package com.hgko.glossary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hgko.glossary.domain.param.SearchParam;
import com.hgko.glossary.service.AbbreviationService;

/**
 * 약어 관리 컨트롤러
 * 
 * @author hgko
 *
 */
@Controller
@RequestMapping("abbr")
public class AbbreviationController {
	
	@Autowired
	private AbbreviationService abbreviationService;

	/**
	 * 목록 화면
	 * @param model
	 */
	@GetMapping("list")
    public void list(Model model) {
    }
	
	/**
	 * 약어 조회
	 * @param param
	 * @return
	 */
	@PostMapping("search")
	public ResponseEntity<?> list(SearchParam param) {
		return new ResponseEntity<>(abbreviationService.getList(param), HttpStatus.OK);
	}
	
	/**
	 * 등록 화면
	 * @param model
	 */
	@GetMapping("regist")
    public void regist(Model model) {
    }
}
