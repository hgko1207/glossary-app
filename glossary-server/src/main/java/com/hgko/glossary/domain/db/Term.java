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
	
	/** 한글명 */
	@Column(length = 45, nullable = false)
	private String name;
	
	/** 영문명 */
	@Column(length = 45, nullable = false)
	private String englishName;
	
	/** 구분 */
	@Column(length = 25, nullable = false)
	private String type;
	
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
