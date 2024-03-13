package com.pruebatecnica.controller;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pruebatecnica.model.request.UserLogin;
import com.pruebatecnica.model.request.UserRegister;
import com.pruebatecnica.model.response.ResponseHttp;
import com.pruebatecnica.repository.User;
import com.pruebatecnica.services.UserServices;

@RestController
@RequestMapping("/services/login")
public class LoginController {
	private static final Logger log = Logger.getLogger(LoginController.class);
	
	//Http message response
	private static final String MSG_REGISTER = "User register";
	private static final String MSG_LOGED = "User loged";
	private static final String WRONG_DATA = "Wrong data";
	
	@Autowired
	UserServices userServices;
	
	@PostMapping("/getUserData")
	public ResponseEntity<?> getUserData(@RequestBody UserLogin userLogin) {
		log.info("Entering method getUserData");
		User user = userServices.getUserByEmail(userLogin.getEmail());
		if(user!=null) {
			return ResponseEntity.ok(user);			
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseHttp(ResponseHttp.STATUS_ERROR, WRONG_DATA));
		}
		
	}
	
	@PostMapping("/register")
	public ResponseEntity<?> register(@RequestBody UserRegister userRegister) {
		log.info("Entering method register");
		if(userServices.createUserAndCheckingAccount(
				userRegister.getName(), 
				userRegister.getLastname(), 
				userRegister.getEmail(), 
				userRegister.getPassword())) {
			return ResponseEntity.ok( new ResponseHttp(ResponseHttp.STATUS_DONE, MSG_REGISTER));			
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseHttp(ResponseHttp.STATUS_ERROR, WRONG_DATA));
		}
		
	}
}
