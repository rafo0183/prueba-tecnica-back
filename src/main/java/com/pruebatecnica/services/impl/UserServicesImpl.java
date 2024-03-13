package com.pruebatecnica.services.impl;

import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.pruebatecnica.dao.CheckingAccountDAO;
import com.pruebatecnica.dao.UserDAO;
import com.pruebatecnica.model.request.UserToEdit;
import com.pruebatecnica.repository.CheckingAccount;
import com.pruebatecnica.repository.User;
import com.pruebatecnica.services.UserServices;

@Service
public class UserServicesImpl implements UserServices{
	
	@Autowired
	UserDAO userDao;
	
	@Autowired
	CheckingAccountDAO checkingAccountDAO; 


	@Override
	public Boolean comprobateLogin(String email, String password) {
		User user = userDao.getUserWithEmailPassword(email, password);
		return user != null;
	}


	@Override
	public User getUserByEmail(String email) {
		User user = userDao.getUserByEmail(email);
		return user;
	}


	@Override
	public boolean createUserAndCheckingAccount(String name, String lastName, String email, String password) {
		User user = new User();
		CheckingAccount checkingAccount = new CheckingAccount();
		try {
			if(this.getUserByEmail(email) == null) {
				password = new BCryptPasswordEncoder().encode(password);
				
				
				user.setName(name);
				user.setLastname(lastName);
				user.setEmail(email);
				user.setPassword(password);
				user.setRole(User.ROLE_CLIENT);
				user.setCreatedAt(new Date());
				user.setUpdatedAt(new Date());
				user.setIsDeleted(false);
				
				user = userDao.insert(user);
				
				
				checkingAccount.setUser(user);
				checkingAccount.setAccountBalance(100_000L);
				checkingAccount.setAccountOverdraft(30_000L);
				checkingAccount.setRewardPoints(50000L);
				checkingAccount.setCreatedAt(new Date());
				checkingAccount.setUpdatedAt(new Date());
				checkingAccount.setAccountNumber(generateAccountNumber());
				
				checkingAccount = checkingAccountDAO.insert(checkingAccount);
							
			}else {
				throw new Exception("Cannot create new user");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(user.getId() != null && checkingAccount.getId() != null) 
				return true;
			
		}
		return false;
	}


	private Long generateAccountNumber() {
		return (long)(Math.random() * (100000 - 10000)) + 10000;
	}


	@Override
	public List<User> getUserList() {
		return userDao.getUserList();
	}


	@Override
	public boolean updateUser(UserToEdit userToEdit) {
		User user = userDao.get(userToEdit.getId());
		if(!userToEdit.getIsDeleted()) {
			user.setName(userToEdit.getName());
			user.setLastname(userToEdit.getLastname());
			user.setEmail(userToEdit.getEmail());
			user.setPassword(userToEdit.getPassword());
			user.setRole(userToEdit.getRole());
			user.setUpdatedAt(new Date());
			user.setIsDeleted(Boolean.FALSE);
		}else {
			user.setIsDeleted(Boolean.TRUE);
		}
		
		try {
			userDao.insert(user);
			return true;			
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		
		
	}

}
