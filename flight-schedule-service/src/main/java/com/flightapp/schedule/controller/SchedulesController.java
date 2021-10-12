package com.flightapp.schedule.controller;

import javax.validation.Valid;

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

import com.flightapp.schedule.modal.FlightSchedule;
import com.flightapp.schedule.service.ScheduleService;

@RestController
@RequestMapping("/app/v1.0/flight/schedule")
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

	// Get all schedule flights
	@GetMapping("/flights/{id}")
	public ResponseEntity<?> retriveFlightOnSchedule(@PathVariable Long id) {
		LOG.info("Getting the flights on schedule");

		return ResponseEntity.status(HttpStatus.OK).body(scheduleService.retriveScheduleFlightById(id));
	}

	// post adding schedule flight
	@PutMapping("/flights/{id}")
	public ResponseEntity<?> updateFlightOnSchedule(@Valid @RequestBody FlightSchedule flight, @PathVariable long id) {
		LOG.info("adding the flight on schedule");
		scheduleService.rescheduleFlight(flight, id);
		LOG.info("flight schedule");
		return ResponseEntity.status(HttpStatus.CREATED).body(flight);
	}

	// post adding schedule flight
	@Transactional(propagation = Propagation.REQUIRED)
	@PostMapping("/flights")
	public ResponseEntity<?> addFlightOnSchedule(@Valid @RequestBody FlightSchedule flight) {
		LOG.info("adding the flight on schedule");
		scheduleService.addFlightOnSchedule(flight);
		LOG.info("flight schedule");
		return ResponseEntity.status(HttpStatus.CREATED).body(flight);
	}

}
