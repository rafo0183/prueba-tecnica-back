package com.pruebatecnica.controller;


import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerHolaMundo {
	private static final Logger log = Logger.getLogger(ControllerHolaMundo.class);
	
	public ControllerHolaMundo() {
		BasicConfigurator.configure();		
	}
	
	@GetMapping("/services/prueba")
	public String prueba() {
		log.info("Hola mundo");
		return "Esta es una prueba de Hola Mundo";
	}
	
	/*
	@GetMapping("/services/pruebabd")
	public List<User> pruebaBd() {
		return userServices.findAllUsers();
	}
	
	@PostMapping("/services/pruebaUser")
	public List<User> pruebaUser() {
		return userServices.findAllUsers();
	}
	*/
}
