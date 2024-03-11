package com.pruebatecnica.dao;



import com.pruebatecnica.repository.Product;

public interface ProductDAO extends DAO<Product, Long>{

	void subtractStock(String sku, int i);

	
	
}
