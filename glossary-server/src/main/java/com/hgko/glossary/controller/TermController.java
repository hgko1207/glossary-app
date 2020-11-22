package com.hgko.glossary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hgko.glossary.domain.db.Term;
import com.hgko.glossary.domain.param.SearchParam;
import com.hgko.glossary.service.TermService;

/**
 * 용어 관리 컨트롤러
 * 
 * @author hgko
 *
 */
@Controller
@RequestMapping("term")
public class TermController {
	
	@Autowired
	private TermService termService;
	
	/**
	 * 목록 화면
	 * @param model
	 */
	@GetMapping("list")
    public void list(Model model) {
    }

	/**
	 * 용어 조회
	 * @param param
	 * @return
	 */
	@PostMapping("search")
	public ResponseEntity<?> list(SearchParam param) {
		return new ResponseEntity<>(termService.getList(param), HttpStatus.OK);
	}

	/**
	 * 등록 화면
	 * @param model
	 */
	@GetMapping("regist")
    public void regist(Model model) {
    }
	
	/**
	 * 용어 등록
	 * @param term
	 * @return
	 */
	@PostMapping("regist")
	public ResponseEntity<?> regist(Term term) {
		if (termService.regist(term)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * 용어 수정
	 * @param term
	 * @return
	 */
	@PutMapping("update")
	public ResponseEntity<?> update(Term term) {
		if (termService.update(term)) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * 용어 삭제
	 * @param term
	 * @return
	 */
	@DeleteMapping("delete")
	public ResponseEntity<?> delete(Term term) {
		if (termService.delete(term.getId())) {
			return new ResponseEntity<>(HttpStatus.OK);
		}
		
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
}
