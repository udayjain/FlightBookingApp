package com.flightapp.schedule.controller;

import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.schedule.exception.ResourceNotFoundException;
import com.flightapp.schedule.modal.FlightSchedule;
import com.flightapp.schedule.payload.SerachFlightRequest;
import com.flightapp.schedule.service.ScheduleService;

@RestController
@RequestMapping("/app/v1.0/schedule")
public class SchedulesController {
	private static final Logger LOG = LoggerFactory.getLogger(SchedulesController.class);

	@Autowired
	private ScheduleService scheduleService;

	// Get all schedule flights
	@GetMapping("/flights")
	public ResponseEntity<?> retriveAllFlightOnSchedule() {
		LOG.info("Getting the flights on schedule");

		return ResponseEntity.status(HttpStatus.OK).body(scheduleService.retriveAllFlightOnSchedule());
	}
	
	@GetMapping("/flights/active")
	public ResponseEntity<?> retriveAllFlightsByActiveAirline() {
		LOG.info("Getting the flights on schedule");

		return ResponseEntity.status(HttpStatus.OK).body(scheduleService.retriveAllFlightsByActiveArline());
	}

	// Get all schedule flights
	@PostMapping("/flights/find")
	public ResponseEntity<?> retriveAllFlightsOnDate(@Valid @RequestBody SerachFlightRequest search) throws ResourceNotFoundException{

		LOG.info("Getting the flights on schedule");
		LOG.info(search.toString());
		return ResponseEntity.status(HttpStatus.OK).body(
				scheduleService.retriveAllFlightsByDate(search.getSrc(), search.getDest(), search.getJournyDate())
				);
	}

	// Get all schedule flights
	@GetMapping("/flights/{id}")
	public ResponseEntity<FlightSchedule> retriveFlightOnSchedule(@PathVariable Long id)
			throws ResourceNotFoundException, Exception {
		LOG.info("Getting the flights on schedule");

		return ResponseEntity.status(HttpStatus.OK).body(scheduleService.retriveFlightById(id));
	}

	// post adding schedule flight
	@PutMapping("/flights/{id}")
	public ResponseEntity<?> updateFlightOnSchedule(@Valid @RequestBody FlightSchedule flight, @PathVariable long id) {
		LOG.info("adding the flight on schedule");
		LOG.info("flight schedule");
		return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.rescheduleFlight(flight, id));
	}

	
	// post adding schedule flight
	
	@PostMapping("/flights")
	public ResponseEntity<?> addFlightOnSchedule(@Valid @RequestBody FlightSchedule flight) {
		
		LOG.info("adding the flight on schedule");
		LOG.info("flight schedule");
		return ResponseEntity.status(HttpStatus.CREATED).body(scheduleService.addFlightOnSchedule(flight));
	}

}
