package com.flightapp.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.flightapp.admin.modal.Airport;

@Repository
public interface AirportRepository extends JpaRepository<Airport, Long> {
		
}
