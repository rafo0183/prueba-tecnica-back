package com.pruebatecnica.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pruebatecnica.dao.CheckingAccountDAO;
import com.pruebatecnica.dao.TransferDAO;
import com.pruebatecnica.dao.UserDAO;
import com.pruebatecnica.model.request.PageRequest;
import com.pruebatecnica.model.response.PageResponse;
import com.pruebatecnica.repository.CheckingAccount;
import com.pruebatecnica.repository.CheckingAccountRepository;
import com.pruebatecnica.repository.Transfer;
import com.pruebatecnica.repository.TransferRepository;
import com.pruebatecnica.repository.User;
import com.pruebatecnica.repository.UserRepository;

@Repository
public class TransferDAOImpl implements TransferDAO{
	@Autowired
	TransferRepository transferRepository;

	@Override
	public Transfer insert(Transfer transfer) {
		return transferRepository.save(transfer);
	}

	@Override
	public void update(Transfer t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Transfer t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Transfer> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Transfer get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transfer> getTransferListByUserId(Long userId) {
		return transferRepository.getTransferListByUserId(userId);
	}

	@Override
	public List<Transfer> getAllTransfers(int start, int size) {		
		return transferRepository.getAllTransfers(start, size);
	}

	@Override
	public Integer countAllTransfers() {
		return transferRepository.countAllTransfers();
	}

}
