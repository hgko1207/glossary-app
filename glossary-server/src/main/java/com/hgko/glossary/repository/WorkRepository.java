package com.hgko.glossary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hgko.glossary.domain.db.Word;

@Repository
public interface WorkRepository extends JpaRepository<Word, Long> {

}
