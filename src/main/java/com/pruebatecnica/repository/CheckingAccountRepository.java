package com.pruebatecnica.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CheckingAccountRepository extends JpaRepository<CheckingAccount, Long>{
	@Query("SELECT ca FROM CheckingAccount ca WHERE ca.user.id = :userId")
	Optional<CheckingAccount> getCheckingAccountByUserId(@Param("userId") Long userId);
}
