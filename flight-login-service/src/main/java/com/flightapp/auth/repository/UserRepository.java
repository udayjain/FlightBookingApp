package com.flightapp.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.auth.modal.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	Optional<User>  findByEmailId(String email);
	 
	 boolean existsByEmailId(String email);
}
