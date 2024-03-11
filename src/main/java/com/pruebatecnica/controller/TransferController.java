package com.pruebatecnica.controller;


import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatecnica.model.request.CartItem;
import com.pruebatecnica.model.request.PageRequest;
import com.pruebatecnica.model.request.TransferInformation;
import com.pruebatecnica.model.response.PageResponse;
import com.pruebatecnica.model.response.ResponseHttp;
import com.pruebatecnica.repository.Transfer;
import com.pruebatecnica.repository.User;
import com.pruebatecnica.services.TransferServices;
import com.pruebatecnica.services.UserServices;

@RestController
@RequestMapping("/services/transfer")
public class TransferController {
	private static final Logger log = Logger.getLogger(TransferController.class);
	
	//Http message response
	private static final String WRONG_DATA = "Wrong data";
	private static final String MSG_TRANSACTION_DONE = "Transaction done";
	
	@Autowired
	UserServices userServices;
	
	@Autowired
	TransferServices transferServices;
	
	@GetMapping("/get-transfer-list/{userId}")
	public ResponseEntity<?> getTransferList(@PathVariable("userId") String userId) {
		log.info("Entering method getTransferList");
		Long userIdL = Long.parseLong(userId);
		List<Transfer> transfers = transferServices.getTransferListByUserId(userIdL);
		if(transfers != null) {
			return ResponseEntity.ok(transfers);			
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseHttp(ResponseHttp.STATUS_ERROR, WRONG_DATA));
		}
		
	}
	
	@PostMapping("/make-a-transfer")
	public ResponseEntity<?> makeATransfer(@RequestBody TransferInformation transferInformation) {
		log.info("Entering method makeATransfer");
		if(transferServices.makeATransfer(transferInformation)) {
			return ResponseEntity.ok(new ResponseHttp(ResponseHttp.STATUS_DONE, MSG_TRANSACTION_DONE));			
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseHttp(ResponseHttp.STATUS_ERROR, WRONG_DATA));
		}
		
	}
	
	@PostMapping("/redeem-points/{userId}")
	public ResponseEntity<?> redeemPoints(@PathVariable("userId") String userId, @RequestBody List<CartItem> cart) {
		log.info("Entering method makeATransfer");
		Long userIdLg = Long.parseLong(userId);
		if(transferServices.redeemPoints(userIdLg,cart)) {
			return ResponseEntity.ok(new ResponseHttp(ResponseHttp.STATUS_DONE, MSG_TRANSACTION_DONE));			
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseHttp(ResponseHttp.STATUS_ERROR, WRONG_DATA));
		}
		
	}
	
	@PostMapping("/get-all-transfers")
	public ResponseEntity<?> getAllTransfers(@RequestBody PageRequest pageRequest) {
		log.info("Entering method getAllTransfers");
		PageResponse response = transferServices.getAllTransfers(pageRequest);
		if(response!=null) {
			return ResponseEntity.ok(response);			
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseHttp(ResponseHttp.STATUS_ERROR, WRONG_DATA));
		}
		
	}
}
