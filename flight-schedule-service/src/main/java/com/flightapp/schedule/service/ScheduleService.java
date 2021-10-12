package com.flightapp.schedule.service;

import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.flightapp.schedule.exception.ResourceNotFoundException;
import com.flightapp.schedule.modal.FlightSchedule;
import com.flightapp.schedule.respository.ScheduleRepository;

@Service
@Transactional
public class ScheduleService {
	private  static final Logger LOG =  LoggerFactory.getLogger(ScheduleService.class);
	
	@Autowired
	private ScheduleRepository scheduleRepo;
 
	//adding the flight on schedule
	public FlightSchedule addFlightOnSchedule(FlightSchedule flight) {
		LOG.info("scheduling flight");
		return scheduleRepo.save(flight);		
	}
	
	
	//updating the flight on schedule
	public FlightSchedule rescheduleFlight(@Valid FlightSchedule flight, long id) throws ResourceNotFoundException{
		FlightSchedule upflight = scheduleRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Flight Schedule", "Id", id));
		LOG.info("Rescheduling flight");
		return scheduleRepo.save(flight);		
	}
	
	
	//Get the flight on schedules
	public List<FlightSchedule> retriveAllFlightOnSchedule() {
		return scheduleRepo.findAllByflightDateGreaterThanEqualAndDepartureTimeGreaterThan(
				new Date(),
				new Date()
				);		
	}
	
	
	//Get the flight on schedule by id
	public FlightSchedule restriveFlightById(@Valid Long id) {
		return scheduleRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Flight Schedule", "Id", id));		
	}
	
	
	//Delete the flight on schedule
	public void RemoveFlight(long id) throws ResourceNotFoundException{
		if(scheduleRepo.existsById(id))
			scheduleRepo.deleteById(id);
		else
			new ResourceNotFoundException("Flight Schedule", "Id", id);			
	}


	public Object retriveScheduleFlightById(Long id) {
		
		return null;
	}
	
}
