package com.pruebatecnica.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pruebatecnica.dao.CheckingAccountDAO;
import com.pruebatecnica.dao.UserDAO;
import com.pruebatecnica.repository.CheckingAccount;
import com.pruebatecnica.repository.CheckingAccountRepository;
import com.pruebatecnica.repository.User;
import com.pruebatecnica.repository.UserRepository;

@Repository
public class CheckingAccountDAOImpl implements CheckingAccountDAO{
	@Autowired
	CheckingAccountRepository checkingAccountRepository;

	@Override
	public CheckingAccount insert(CheckingAccount checkingAccount) {
		return checkingAccountRepository.save(checkingAccount);
	}

	@Override
	public void update(CheckingAccount checkingAccount) {
		checkingAccountRepository.save(checkingAccount);
	}

	@Override
	public void delete(CheckingAccount t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CheckingAccount> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CheckingAccount get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CheckingAccount getCheckingAccountByUserId(Long userId) {
		Optional<CheckingAccount> opt = checkingAccountRepository.getCheckingAccountByUserId(userId);
		return opt.get();
	}
}
