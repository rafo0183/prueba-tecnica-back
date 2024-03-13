package com.pruebatecnica.controller;


import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatecnica.model.request.TransferInformation;
import com.pruebatecnica.model.request.UserToEdit;
import com.pruebatecnica.model.response.ResponseHttp;
import com.pruebatecnica.repository.CheckingAccount;
import com.pruebatecnica.repository.User;
import com.pruebatecnica.services.UserServices;

@RestController
@RequestMapping("/services/user")
public class UserController {
	private static final Logger log = Logger.getLogger(UserController.class);
	private static final String WRONG_DATA = "Wrong data";
	
	private static final String MSG_USER_UPDATED = "User updated";
	
	@Autowired
	UserServices userServices;
	
	public UserController() {
		BasicConfigurator.configure();		
	}
	
	@GetMapping("/getUserList")
	public  ResponseEntity<?> getUserList() {
		log.info("Entering method getUserList");
		List<User> userList = userServices.getUserList();
		if(userList.size() > 0) {
			return ResponseEntity.ok(userList);				
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseHttp(ResponseHttp.STATUS_ERROR, WRONG_DATA));
		}
	}
	
	@PostMapping("/save-user")
	public ResponseEntity<?> saveUser(@RequestBody UserToEdit userToEdit) {
		log.info("Entering method makeATransfer");
		if(userServices.updateUser(userToEdit)) {
			return ResponseEntity.ok(new ResponseHttp(ResponseHttp.STATUS_DONE, MSG_USER_UPDATED));
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseHttp(ResponseHttp.STATUS_ERROR, WRONG_DATA));
		}
		
	}
}
