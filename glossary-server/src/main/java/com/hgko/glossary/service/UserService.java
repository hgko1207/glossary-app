package com.hgko.glossary.service;

import com.hgko.glossary.domain.db.User;

public interface UserService extends CRUDService<User, Long> {

	User login(String username, String password);

}
