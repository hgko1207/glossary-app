package com.hgko.glossary.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hgko.glossary.domain.db.Word;
import com.hgko.glossary.repository.WorkRepository;

@Service
public class WorkService {

	@Autowired
	private WorkRepository workRepository;
	
	public List<Word> getList() {
		return workRepository.findAll();
	}
}
