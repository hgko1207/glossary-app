package com.hgko.glossary.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hgko.glossary.domain.db.Abbreviation;

@Repository
public interface AbbreviationRepository extends DefaultRepository<Abbreviation, Long> {

	List<Abbreviation> findByNameContaining(String name);

}
