package com.pruebatecnica.services.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebatecnica.dao.CheckingAccountDAO;
import com.pruebatecnica.dao.ProductDAO;
import com.pruebatecnica.dao.TransferDAO;
import com.pruebatecnica.dao.UserDAO;
import com.pruebatecnica.model.request.CartItem;
import com.pruebatecnica.model.request.PageRequest;
import com.pruebatecnica.model.request.TransferInformation;
import com.pruebatecnica.model.response.PageResponse;
import com.pruebatecnica.repository.CheckingAccount;
import com.pruebatecnica.repository.Transfer;
import com.pruebatecnica.repository.User;
import com.pruebatecnica.services.CheckingAccountServices;
import com.pruebatecnica.services.TransferServices;

@Service
public class TransferServicesImpl implements TransferServices{

	@Autowired
	UserDAO userDao;
	
	@Autowired
	TransferDAO transferDao;
	
	@Autowired
	CheckingAccountDAO checkingAccountDao;
	
	@Autowired
	ProductDAO productDAO;


	@Override
	public List<Transfer> getTransferListByUserId(Long userId) {
		User user = userDao.get(userId);
		if(user != null) {
			return transferDao.getTransferListByUserId(userId);
		}
		return null;
	}


	@Override
	public Boolean makeATransfer(TransferInformation transferInformation) {
		try {
			UUID uuid = UUID.randomUUID();
			CheckingAccount checkingAccount = checkingAccountDao.getCheckingAccountByUserId(transferInformation.getUserId().getId());
			 
			Transfer transfer = new Transfer();
			transfer.setUser(transferInformation.getUserId());
			transfer.setCheckingAccount(checkingAccount);
			transfer.setHash(uuid.toString());
			transfer.setCheckingAccountDestination(transferInformation.getCheckingAccountDestination());
			transfer.setBankDestination(transferInformation.getBankDestination());
			transfer.setNameDestination(transferInformation.getNameDestination());
			transfer.setAmount(transferInformation.getAmount());
			transfer.setCreatedAt(new Date());
			transfer.setUpdatedAt(new Date());
			transferDao.insert(transfer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
	}


	@Override
	public boolean redeemPoints(Long userId, List<CartItem> cart) {
		long amountDiscount = 0; 
		for(CartItem cartItem : cart) {
			productDAO.subtractStock(cartItem.getSku(), 1);
			amountDiscount += cartItem.getPrice();
		}
		CheckingAccount checkingAccount = checkingAccountDao.getCheckingAccountByUserId(userId);
		checkingAccount.setRewardPoints(checkingAccount.getRewardPoints()-amountDiscount);
		checkingAccountDao.update(checkingAccount);
		// Aquí falta la tabla que registra las transacciones de puntos
		return true;
	}


	@Override
	public PageResponse getAllTransfers(PageRequest pageRequest) {
		int size = pageRequest.getRowsPerPage();
		int currentPage = pageRequest.getCurrentPage();
		int start = size * currentPage;
		System.out.println("size:" + size + " currentPage" + currentPage + " start" + start);
		
		Integer countAllTransfer = transferDao.countAllTransfers(); 
		List<Transfer> transferList = transferDao.getAllTransfers(start, size); 
		
		pageRequest.setTotalRows(countAllTransfer);
		PageResponse pageResponse = new PageResponse(pageRequest, (List) transferList);
		
		return pageResponse;
	}

}
