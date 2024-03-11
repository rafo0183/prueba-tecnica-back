package com.pruebatecnica.controller;


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

import com.pruebatecnica.model.request.UserLogin;
import com.pruebatecnica.model.request.UserRegister;
import com.pruebatecnica.model.response.ResponseHttp;
import com.pruebatecnica.repository.CheckingAccount;
import com.pruebatecnica.services.CheckingAccountServices;
import com.pruebatecnica.services.UserServices;

@RestController
@RequestMapping("/services/checking-accounts")
public class CheckingAccountsController {
	private static final Logger log = Logger.getLogger(CheckingAccountsController.class);
	
	//Http message response
	private static final String WRONG_DATA = "Wrong data";
	
	@Autowired
	CheckingAccountServices checkingAccountServices;
	
	@GetMapping("/checking-account-by-user/{userId}")
	public ResponseEntity<?> checkingAccountByUser(@PathVariable("userId") String userId) {
		log.info("Entering method checkingAccountByUser");
		Long userIdL = Long.parseLong(userId);
		CheckingAccount checkingAcocunt = checkingAccountServices.getCheckingAccountByUserId(userIdL);
		if(checkingAcocunt != null) {
			return ResponseEntity.ok(checkingAcocunt);			
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseHttp(ResponseHttp.STATUS_ERROR, WRONG_DATA));
		}
	}
}
