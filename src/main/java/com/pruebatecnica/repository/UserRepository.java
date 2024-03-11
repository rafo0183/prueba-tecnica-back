package com.pruebatecnica.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("SELECT u FROM User u WHERE u.email = :email AND u.password = :password")
	Optional<User> getUserWithEmailPassword(@Param("email") String email,@Param("password") String password);

	@Query("SELECT u FROM User u WHERE u.email = :email")
	Optional<User> getUserByEmail(String email);

	@Query("SELECT u FROM User u")
	List<User> getUserList();
}
