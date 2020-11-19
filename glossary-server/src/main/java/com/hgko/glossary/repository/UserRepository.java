package com.hgko.glossary.repository;

import org.springframework.stereotype.Repository;

import com.hgko.glossary.domain.db.User;

@Repository
public interface UserRepository extends DefaultRepository<User, Long> {

	User findByUserIdAndPassword(String username, String password);
}
