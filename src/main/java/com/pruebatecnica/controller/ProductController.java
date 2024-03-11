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

import com.pruebatecnica.model.request.TransferInformation;
import com.pruebatecnica.model.response.ResponseHttp;
import com.pruebatecnica.repository.Product;
import com.pruebatecnica.repository.Transfer;
import com.pruebatecnica.repository.User;
import com.pruebatecnica.services.ProductServices;
import com.pruebatecnica.services.TransferServices;
import com.pruebatecnica.services.UserServices;

@RestController
@RequestMapping("/services/product")
public class ProductController {
	private static final Logger log = Logger.getLogger(ProductController.class);
	
	//Http message response
	private static final String WRONG_DATA = "Wrong data";
	
	@Autowired
	UserServices userServices;
	
	@Autowired
	ProductServices productServices;
	
	@GetMapping("/get-product-list")
	public ResponseEntity<?> getProductList() {
		log.info("Entering method getTransferList");
		List<Product> transfers = productServices.getProductList();
		if(transfers != null) {
			return ResponseEntity.ok(transfers);			
		}else {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseHttp(ResponseHttp.STATUS_ERROR, WRONG_DATA));
		}
		
	}
}
