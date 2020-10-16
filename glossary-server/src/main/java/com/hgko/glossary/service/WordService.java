package com.hgko.glossary.service;

import java.util.List;

import com.hgko.glossary.domain.db.Word;
import com.hgko.glossary.domain.param.SearchParam;

public interface WordService extends CRUDService<Word, Long> {

	List<Word> getList(SearchParam param);
}
