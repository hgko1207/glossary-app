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
 * 약어 관리 테이블 도메인
 * 
 * @author hgko
 *
 */
@Data
@Entity
@Table(name = "tb_ㅁbbreviation")
public class Abbreviation implements Domain {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	/** 약어 */
	@Column(length = 45, nullable = false)
	private String name;
	
	/** 약어 풀이 */
	@Column(length = 255, nullable = false)
	private String fullName;
	
	/** 설명 */
    @Column(length = 255)
    private String description;
    
    /** 등록일시 */
    @CreationTimestamp
    private LocalDateTime createDate;
    
    /** 수정일시 */
    @UpdateTimestamp
    private LocalDateTime updateDate;
}
