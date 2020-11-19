package com.hgko.glossary.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hgko.glossary.domain.db.User;
import com.hgko.glossary.repository.UserRepository;
import com.hgko.glossary.service.UserService;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<User> getList() {
		return userRepository.findAll();
	}

	@Override
	public User get(Long id) {
		return userRepository.findById(id).get();
	}

	@Override
	public boolean regist(User domain) {
		if (isNew(domain)) {
			return userRepository.save(domain) != null;
		} else {
			return false;
		}	
	}

	@Override
	public boolean update(User domain) {
		if (!isNew(domain)) {
			return userRepository.save(domain) != null;
		} else {
			return false;
		}	
	}

	@Override
	public boolean delete(Long id) {
		userRepository.deleteById(id);
		return true;
	}
	
	private boolean isNew(User domain) {
		return !userRepository.existsById(domain.getId());
	}

	@Override
	public User login(String username, String password) {
		return userRepository.findByUserIdAndPassword(username, password);
	}

}
