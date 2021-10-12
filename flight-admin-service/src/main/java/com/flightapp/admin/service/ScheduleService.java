package com.flightapp.admin.service;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.flightapp.admin.controller.AdminController;
import com.flightapp.admin.modal.FlightSchedule;

@Service
@Transactional
public class ScheduleService {
	private static final String URL = "http://localhost:9004/app/v1.0/flight/schedule/flights";
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ScheduleService.class);
	
	@Autowired
	private RestTemplate scheduleClient; 
	
	
	@Transactional(propagation = Propagation.REQUIRED)
	public ResponseEntity<?> addFlightOnSchedule(@Valid FlightSchedule flightSchedule) {
		FlightSchedule flight  = scheduleClient.postForObject(URL, flightSchedule, FlightSchedule.class);
		return ResponseEntity.status(HttpStatus.CREATED).body(flight);
	}	
}
