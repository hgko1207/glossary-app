package com.hgko.glossary.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hgko.glossary.domain.db.Abbreviation;
import com.hgko.glossary.repository.AbbreviationRepository;
import com.hgko.glossary.service.AbbreviationService;

@Transactional
@Service
public class AbbreviationServiceImpl implements AbbreviationService {

	@Autowired
	private AbbreviationRepository abbreviationRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Abbreviation> getList() {
		return abbreviationRepository.findAll();
	}

	@Override
	public Abbreviation get(Long id) {
		return abbreviationRepository.findById(id).get();
	}

	@Override
	public boolean regist(Abbreviation domain) {
		if (isNew(domain)) {
			return abbreviationRepository.save(domain) != null;
		} else {
			return false;
		}	
	}

	@Override
	public boolean update(Abbreviation domain) {
		if (!isNew(domain)) {
			return abbreviationRepository.save(domain) != null;
		} else {
			return false;
		}	
	}

	@Override
	public boolean delete(Long id) {
		abbreviationRepository.deleteById(id);
		return true;
	}
	
	private boolean isNew(Abbreviation domain) {
		return !abbreviationRepository.existsById(domain.getId());
	}
}
