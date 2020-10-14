package com.hgko.glossary.repository;

import org.springframework.stereotype.Repository;
import com.hgko.glossary.domain.db.Word;

@Repository
public interface WorkRepository extends DefaultRepository<Word, Long> {
}
