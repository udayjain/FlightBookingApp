package com.flightapp.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.admin.modal.Airline;

@Repository
public interface AirlineRepository extends JpaRepository<Airline, Long> {
		
}
