package com.hgko.glossary.repository;

import org.springframework.stereotype.Repository;

import com.hgko.glossary.domain.db.Abbreviation;

@Repository
public interface AbbreviationRepository extends DefaultRepository<Abbreviation, Long> {

}
