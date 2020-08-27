package com.hgko.glossary.domain.db;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.hgko.glossary.domain.Domain;

import lombok.Data;

/**
 * 용어 관리 테이블 도메인
 * 
 * @author hgko
 *
 */
@Data
public class Term implements Domain {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	private String name;
}
