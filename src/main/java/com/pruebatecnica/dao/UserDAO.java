package com.pruebatecnica.dao;

import java.util.List;

import com.pruebatecnica.repository.User;

public interface UserDAO extends DAO<User, Long>{

	User getUserWithEmailPassword(String email, String password);

	User getUserByEmail(String email);

	List<User> getUserList();
	
	
}
