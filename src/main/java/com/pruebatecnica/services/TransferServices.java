package com.pruebatecnica.services;

import java.util.List;

import com.pruebatecnica.model.request.CartItem;
import com.pruebatecnica.model.request.PageRequest;
import com.pruebatecnica.model.request.TransferInformation;
import com.pruebatecnica.model.response.PageResponse;
import com.pruebatecnica.repository.Transfer;

public interface TransferServices {
	List<Transfer> getTransferListByUserId(Long userId);
	
	Boolean makeATransfer(TransferInformation transferInformation);

	boolean redeemPoints(Long userId, List<CartItem> cart);

	PageResponse getAllTransfers(PageRequest pageRequest);
}
