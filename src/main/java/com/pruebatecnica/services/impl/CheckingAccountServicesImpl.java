package com.pruebatecnica.services.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebatecnica.dao.CheckingAccountDAO;
import com.pruebatecnica.dao.UserDAO;
import com.pruebatecnica.repository.CheckingAccount;
import com.pruebatecnica.repository.User;
import com.pruebatecnica.services.CheckingAccountServices;

@Service
public class CheckingAccountServicesImpl implements CheckingAccountServices{
	@Autowired
	UserDAO userDao;
	
	@Autowired
	CheckingAccountDAO checkingAccountDAO;

	@Override
	public CheckingAccount getCheckingAccountByUserId(Long userId) {
		User user = userDao.get(userId);
		if(user != null) {
			return checkingAccountDAO.getCheckingAccountByUserId(user.getId());
		}
		
		
		return null;
	} 

}
