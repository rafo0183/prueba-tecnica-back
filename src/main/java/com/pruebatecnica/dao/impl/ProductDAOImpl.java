package com.pruebatecnica.dao.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.pruebatecnica.dao.CheckingAccountDAO;
import com.pruebatecnica.dao.ProductDAO;
import com.pruebatecnica.dao.TransferDAO;
import com.pruebatecnica.dao.UserDAO;
import com.pruebatecnica.repository.CheckingAccount;
import com.pruebatecnica.repository.CheckingAccountRepository;
import com.pruebatecnica.repository.Product;
import com.pruebatecnica.repository.ProductRepository;
import com.pruebatecnica.repository.Transfer;
import com.pruebatecnica.repository.TransferRepository;
import com.pruebatecnica.repository.User;
import com.pruebatecnica.repository.UserRepository;

@Repository
public class ProductDAOImpl implements ProductDAO{
	@Autowired
	ProductRepository productRepository;

	@Override
	public Product insert(Product t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Product t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Product t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Product> getAll() {
		return productRepository.getAll();
	}

	@Override
	public Product get(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void subtractStock(String sku, int i) {
		Product product = productRepository.getBySku(sku);
		product.setStock(product.getStock()-i);
		productRepository.save(product);
	}
	

}
