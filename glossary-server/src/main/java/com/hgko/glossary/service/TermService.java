package com.hgko.glossary.service;

import java.util.List;

import com.hgko.glossary.domain.db.Term;
import com.hgko.glossary.domain.param.SearchParam;

public interface TermService extends CRUDService<Term, Long> {

	List<Term> getList(SearchParam param);
}
