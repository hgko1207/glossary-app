package com.hgko.glossary.service;

import java.util.List;

import com.hgko.glossary.domain.db.Abbreviation;
import com.hgko.glossary.domain.param.SearchParam;

public interface AbbreviationService extends CRUDService<Abbreviation, Long> {

	List<Abbreviation> getList(SearchParam param);

}
