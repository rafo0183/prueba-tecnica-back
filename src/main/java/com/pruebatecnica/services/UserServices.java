package com.pruebatecnica.services;

import java.util.List;

import com.pruebatecnica.repository.User;

public interface UserServices {
	Boolean comprobateLogin(String email, String password);
	
	User getUserByEmail(String email);

	boolean createUserAndCheckingAccount(String name, String lastName, String email, String password);

	List<User> getUserList();
	
}
