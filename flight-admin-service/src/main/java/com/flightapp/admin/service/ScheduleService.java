package com.flightapp.admin.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMethod;
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


	public ResponseEntity<?> reschdeuleFlightOnSchedule(FlightSchedule flightSchedule, Long id) {
		Map<String, Long> param = new HashMap();
		param.put("id", id);
		HttpEntity<FlightSchedule> entity = new HttpEntity<FlightSchedule>(flightSchedule);
		
		ResponseEntity<FlightSchedule> flight  = scheduleClient.exchange(URL+ "/" +id,HttpMethod.PUT, entity, FlightSchedule.class);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(flight);
	}


	public ResponseEntity<?> removeFlightOnSchedule(Long id) {
		scheduleClient.delete(URL+ "/"+id);
		return ResponseEntity.status(HttpStatus.OK).body("Remove Flight from schedule!");
	}


	public ResponseEntity<?> getAllFlightOnSchedule() {
		List<FlightSchedule> flight  = scheduleClient.getForObject(URL+ "/active",List.class);
		
		return ResponseEntity.status(HttpStatus.OK).body(flight);
		
	}


	public ResponseEntity<?> getFlightOnSchedule(Long id) {
		return  scheduleClient.getForEntity(URL+"/" +id,  FlightSchedule.class);		
	}	
}
