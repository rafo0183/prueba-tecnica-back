package com.pruebatecnica.dao;


import java.util.List;

import com.pruebatecnica.model.response.PageResponse;
import com.pruebatecnica.repository.Transfer;

public interface TransferDAO extends DAO<Transfer, Long>{

	List<Transfer> getTransferListByUserId(Long userId);

	List<Transfer> getAllTransfers(int start, int size);
	
	Integer countAllTransfers();
}
