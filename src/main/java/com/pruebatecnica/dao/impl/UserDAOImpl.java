package com.pruebatecnica.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pruebatecnica.dao.UserDAO;
import com.pruebatecnica.repository.User;
import com.pruebatecnica.repository.UserRepository;

@Repository
public class UserDAOImpl implements UserDAO{
	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional
	public User insert(User user) {
		return userRepository.save(user);
	}

	@Override
	public void update(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User get(Long id) {
		Optional<User> opt = userRepository.findById(id);
		if(opt.isPresent()) 
			return opt.get();			
		return null;
	}

	@Override
	public User getUserWithEmailPassword(String email, String password) {
		Optional<User> opt = userRepository.getUserWithEmailPassword(email, password);
		return opt.isPresent() ? opt.get() : null;
	}

	@Override
	public User getUserByEmail(String email) {
		Optional<User> opt = userRepository.getUserByEmail(email);
		return opt.isPresent() ? opt.get() : null;
	}

	@Override
	public List<User> getUserList() {
		return userRepository.getUserList();
	}

}
