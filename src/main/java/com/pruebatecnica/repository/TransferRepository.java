package com.pruebatecnica.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.pruebatecnica.model.request.PageRequest;
import com.pruebatecnica.model.response.PageResponse;

public interface TransferRepository extends JpaRepository<Transfer, Long>{
	@Query("SELECT t FROM Transfer t WHERE t.user.id = :userId")
	List<Transfer> getTransferListByUserId(@Param("userId") Long userId);

	@Query(value="SELECT COUNT(*) FROM transfers t", nativeQuery = true)
	Integer countAllTransfers();
	
	@Query(value="SELECT * FROM transfers t LIMIT :start , :size", nativeQuery = true)
	List<Transfer> getAllTransfers(@Param("start") int start, @Param("size") int size);
	
}
