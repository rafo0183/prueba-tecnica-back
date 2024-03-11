package com.pruebatecnica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Long>{

	@Query("SELECT p FROM Product p")
	List<Product> getAll();

	@Query("SELECT p FROM Product p WHERE p.sku = :sku")
	Product getBySku(@Param("sku") String sku);

	
}
