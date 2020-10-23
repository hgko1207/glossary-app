package com.hgko.glossary.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hgko.glossary.domain.db.Term;
import com.hgko.glossary.domain.param.SearchParam;
import com.hgko.glossary.repository.TermRepository;
import com.hgko.glossary.service.TermService;

@Transactional
@Service
public class TermServiceImpl implements TermService {

	@Autowired
	private TermRepository termRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Term> getList() {
		return termRepository.findAll();
	}

	@Override
	public Term get(Long id) {
		return termRepository.findById(id).get();
	}

	@Override
	public boolean regist(Term domain) {
		if (isNew(domain)) {
			return termRepository.save(domain) != null;
		} else {
			return false;
		}	
	}

	@Override
	public boolean update(Term domain) {
		if (!isNew(domain)) {
			return termRepository.save(domain) != null;
		} else {
			return false;
		}	
	}

	@Override
	public boolean delete(Long id) {
		termRepository.deleteById(id);
		return true;
	}
	
	private boolean isNew(Term domain) {
		return !termRepository.existsById(domain.getId());
	}

	@Transactional(readOnly = true)
	@Override
	public List<Term> getList(SearchParam param) {
		return getList();
	}
}
