package com.hgko.glossary.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hgko.glossary.domain.db.Word;
import com.hgko.glossary.domain.param.SearchParam;
import com.hgko.glossary.repository.WorkRepository;
import com.hgko.glossary.service.WordService;

@Transactional
@Service
public class WordServiceImpl implements WordService {

	@Autowired
	private WorkRepository workRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Word> getList() {
		return workRepository.findAll();
	}

	@Override
	public Word get(Long id) {
		return workRepository.findById(id).get();
	}

	@Override
	public boolean regist(Word domain) {
		if (isNew(domain)) {
			return workRepository.save(domain) != null;
		} else {
			return false;
		}	
	}

	@Override
	public boolean update(Word domain) {
		if (!isNew(domain)) {
			return workRepository.save(domain) != null;
		} else {
			return false;
		}	
	}

	@Override
	public boolean delete(Long id) {
		workRepository.deleteById(id);
		return true;
	}
	
	private boolean isNew(Word domain) {
		return !workRepository.existsById(domain.getId());
	}

	@Transactional(readOnly = true)
	@Override
	public List<Word> getList(SearchParam param) {
		return getList();
	}
}
