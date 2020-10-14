package com.hgko.glossary.domain.db;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.hgko.glossary.domain.Domain;

import lombok.Data;

/**
 * 용어 관리 테이블 도메인
 * 
 * @author hgko
 *
 */
@Entity
@Table(name = "tb_term")
@Data
public class Term implements Domain {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	/** 한글명 - 시스템에서 사용하는 단어를 한글명 혹은 영어(고유단어)로 등록 */
	@Column(length = 45, nullable = false)
	private String name;
	
    /** 설명 - 한글명에 대한 설명을 등록 */
    @Column(length = 255)
    private String description;
	
	/** 등록일시 */
    @CreationTimestamp
    private LocalDateTime createDate;
    
    /** 수정일시 */
    @UpdateTimestamp
    private LocalDateTime updateDate;
}
