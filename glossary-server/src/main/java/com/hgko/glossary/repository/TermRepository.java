package com.hgko.glossary.repository;

import org.springframework.stereotype.Repository;
import com.hgko.glossary.domain.db.Term;

@Repository
public interface TermRepository extends DefaultRepository<Term, Long> {
}
