package com.flightapp.admin.controller;

import java.sql.SQLDataException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.admin.exception.ResourceNotFoundException;
import com.flightapp.admin.modal.Airport;
import com.flightapp.admin.service.AirportService;

@RestController
@RequestMapping("/app/v1.0/flight/admin")
public class AirportController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AirportController.class);

	@Autowired
	private AirportService airportService;

	// Get all airport
	@GetMapping("/airport")
	public List<Airport> retriveAllAirport() {
		LOGGER.info("Looking for all Airport");
		return airportService.retriveAllAirport();
	}

	// Get airport
	@GetMapping("/airport/{id}")
	public Airport retriveAirport(@PathVariable long id) throws ResourceNotFoundException,Exception {
		LOGGER.info("Getting for Airport");
		return airportService.retriveAirport(id);
	}
	
	// post create airport
	@PostMapping("/airport")
	public ResponseEntity<Airport> addAirport(@RequestBody @Valid Airport airport) throws SQLDataException, Exception {
		
		LOGGER.info("Airport adding inprocess");
		return ResponseEntity.status(HttpStatus.CREATED).body(airportService.addAirport(airport));

	}

	// Put update airport
	@PutMapping("/airport/{id}")
	public ResponseEntity<Airport> modifyAirport(@Valid @RequestBody Airport airport,@PathVariable long id)
			throws SQLDataException, ResourceNotFoundException, Exception {

		LOGGER.info("Airport updated successfully");
		return  ResponseEntity.status(HttpStatus.CREATED).body(airportService.modifyAirport(airport, id));
	}

	// block airport
	@PutMapping("/airport/block/{id}")
	public ResponseEntity<?> blockAirport(@PathVariable long id) throws ResourceNotFoundException{
		LOGGER.info("Block Airport by id " + id);
		return airportService.blockAirport(id);
	}

	// unblock airport
	@PutMapping("/airport/unblock/{id}")
	public ResponseEntity<?> unblockAirport(@PathVariable long id) throws ResourceNotFoundException{
		LOGGER.info("Unblock Airport by id " + id);
		return airportService.unblockAirport(id);
	}

	// delete airport
	@DeleteMapping("/airport/block/{id}")
	public ResponseEntity<?> removeAirport(@PathVariable long id) throws ResourceNotFoundException{
		LOGGER.info("Airport Removed aiport of id " + id);
		return airportService.removeAirport(id);
	}
}
