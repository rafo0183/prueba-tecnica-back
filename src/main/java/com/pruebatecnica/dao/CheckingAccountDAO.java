package com.pruebatecnica.dao;

import com.pruebatecnica.repository.CheckingAccount;

public interface CheckingAccountDAO extends DAO<CheckingAccount, Long>{

	CheckingAccount getCheckingAccountByUserId(Long userId);
	
	
}
