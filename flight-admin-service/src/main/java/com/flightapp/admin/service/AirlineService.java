package com.flightapp.admin.service;

import java.sql.SQLDataException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.hibernate.type.TrueFalseType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.flightapp.admin.exception.ResourceNotFoundException;
import com.flightapp.admin.modal.Airline;
import com.flightapp.admin.repository.AirlineRepository;

@Service
@Transactional
public class AirlineService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AirlineService.class);
	
	@Autowired
	private AirlineRepository airlineRespository;	

	@Transactional(propagation =  Propagation.REQUIRED)
	public Airline createAirline(Airline airline) throws SQLDataException , Exception {
		airline.setActive(true);
		LOGGER.info("Airline Created successfully");
		return airlineRespository.save(airline);
	}
	
	@Transactional(propagation =  Propagation.REQUIRED)
	public Airline updateAirline(@Valid Airline airline, long id ) {
		Airline newAirline = airlineRespository.findById(id)
					.orElseThrow(()-> new ResourceNotFoundException("Airline", "Id", id));
		
		newAirline.setAirCode(airline.getAirCode());
		newAirline.setAirlineName(airline.getAirlineName());
		newAirline.setContactNo(airline.getContactNo());
		newAirline.setLogo(airline.getLogo());
		LOGGER.info("Airline updated successfully!");
		return airlineRespository.save(newAirline);
	}
	
	@Transactional(propagation =  Propagation.REQUIRED)
	public ResponseEntity<?> blockAirline(long id) throws ResourceNotFoundException , Exception{	
		Airline airline = airlineRespository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Airline", "Id", id));
		airline.setActive(false);
		airlineRespository.save(airline);
		LOGGER.info("Airline blocked successfully!");
		return ResponseEntity.ok("Airline block Successfully!!");
	}
	
	@Transactional(propagation =  Propagation.REQUIRED)
	public ResponseEntity<?> unBlockAirline(long id) throws ResourceNotFoundException , Exception{	
		Airline airline = airlineRespository.findById(id)
				.orElseThrow(()-> new ResourceNotFoundException("Airline", "Id", id));
		airline.setActive(true);
		airlineRespository.save(airline);
		LOGGER.info("Airline unblocked successfully!");
		return ResponseEntity.ok("Message : Airline Unblock Successfully!!");
	}
	
	
	@Transactional(propagation =  Propagation.REQUIRED , readOnly = true)
	public List<Airline> retriveAllAirline() throws Exception{	
		return  airlineRespository.findAll();
	}
	
	@Transactional(propagation =  Propagation.REQUIRED , readOnly = true)
	public Airline retriveAirline(long id) throws ResourceNotFoundException , Exception {	
		Optional<Airline> airline = airlineRespository.findById(id);
		if(	!airline.isPresent())
				throw new ResourceNotFoundException("Airline", "ID", id);
		
		return airline.get();
	}
	
	@Transactional(propagation =  Propagation.REQUIRED )
	public ResponseEntity<?> removeAirline(long id) throws ResourceNotFoundException , Exception{	
		Optional<Airline> airline = airlineRespository.findById(id);
		if(!airline.isPresent())
				throw new ResourceNotFoundException("Airline", "ID", id);
		
		airlineRespository.delete(airline.get());
		
		return ResponseEntity.ok("Airline Deleted Successfully!!");
	}
}
