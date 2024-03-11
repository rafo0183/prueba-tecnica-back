package com.pruebatecnica.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pruebatecnica.dao.CheckingAccountDAO;
import com.pruebatecnica.dao.ProductDAO;
import com.pruebatecnica.dao.UserDAO;
import com.pruebatecnica.repository.CheckingAccount;
import com.pruebatecnica.repository.Product;
import com.pruebatecnica.repository.User;
import com.pruebatecnica.services.CheckingAccountServices;
import com.pruebatecnica.services.ProductServices;

@Service
public class ProductServicesImpl implements ProductServices{
	@Autowired
	UserDAO userDao;
	
	@Autowired
	ProductDAO productDao;

	@Override
	public List<Product> getProductList() {
		return productDao.getAll();
	}
}
