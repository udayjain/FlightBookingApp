package com.flightapp.admin.service;

import java.sql.SQLDataException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flightapp.admin.exception.ResourceNotFoundException;
import com.flightapp.admin.modal.Airport;
import com.flightapp.admin.repository.AirportRepository;

@Service
@Transactional
public class AirportService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AirportService.class);

	@Autowired
	private AirportRepository airportRepo;

	// Get all airport
	public List<Airport> retriveAllAirport() {
		LOGGER.info("grathering all Airport");
		return airportRepo.findAll();
	}

	// Get airport
	public Airport retriveAirport(long id) {
		LOGGER.info("Getting for Airport");
		return airportRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Airport", "Id", id));
	}
	// block airport

	// post create airport
	public Airport addAirport(Airport airport) throws SQLDataException, Exception {
		airport.setActive(true);
		LOGGER.info("Airport set active");
		LOGGER.info("Airport added successfully");
		return airportRepo.save(airport);
	}

	// Put update airport
	public Airport modifyAirport(Airport airport, long id)
			throws SQLDataException, ResourceNotFoundException, Exception {
		Airport upAirport = airportRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Airport", "Id", id));
		
		
		LOGGER.info("Airport updated successfully");
		return airportRepo.save(upAirport);
	}

	// block airport
	public ResponseEntity<?> blockAirport(long id) {
		Airport airport = airportRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Airport", "Id", id));
		airport.setActive(false);
		LOGGER.info("Airport set inactive as closed");
		airportRepo.save(airport);
		LOGGER.info("Block Airport by id "+ id);
		return ResponseEntity.ok("Aiport block successfully!");
	}
	
	// unblock airport
	public ResponseEntity<?> unblockAirport(long id) {
			Airport airport = airportRepo.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Airport", "Id", id));
			airport.setActive(false);
			LOGGER.info("Airport set active as open");
			airportRepo.save(airport);
			LOGGER.info("Unblock Airport by id "+ id);
			return ResponseEntity.ok("Aiport Unblock successfully!");
		}

	// delete airport
	public ResponseEntity<?> removeAirport(long id) {
		Airport airport = airportRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Airport", "Id", id));
		airportRepo.delete(airport);
		LOGGER.info("Airport Removed aiport of id "+ id);
		return ResponseEntity.ok("Aiport deleted successfully!");
	}
}
