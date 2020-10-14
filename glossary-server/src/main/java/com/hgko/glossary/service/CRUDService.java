package com.hgko.glossary.service;

import java.io.Serializable;
import java.util.List;

import com.hgko.glossary.domain.Domain;

public interface CRUDService<T extends Domain, ID extends Serializable> {
	
	T get(ID id);
	
	List<T> getList();
	
	boolean regist(T domain);

	boolean update(T domain);
	
	boolean delete(ID id);
	
}
