package com.flightapp.schedule.service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;

import javax.transaction.Transaction;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.flightapp.schedule.exception.ResourceNotFoundException;
import com.flightapp.schedule.modal.Flight;
import com.flightapp.schedule.modal.FlightSchedule;
import com.flightapp.schedule.respository.ScheduleRepository;

@Service
@Transactional
public class ScheduleService {
	private static final Logger LOG = LoggerFactory.getLogger(ScheduleService.class);

	@Autowired
	private ScheduleRepository scheduleRepo;

	// adding the flight on schedule
	@Transactional(propagation = Propagation.REQUIRED)
	public FlightSchedule addFlightOnSchedule(FlightSchedule flight) {
		LOG.info("scheduling flight");
		return scheduleRepo.save(flight);
	}

	// updating the flight on schedule
	@Transactional(propagation = Propagation.REQUIRED)
	public FlightSchedule rescheduleFlight(@Valid FlightSchedule flight, long id) throws ResourceNotFoundException {
		FlightSchedule upflight = scheduleRepo.findById(id).map(f -> {
			f.setFlightStatus(flight.getFlightStatus());
			f.setFares(flight.getFares());
			f.setFlightDate(flight.getFlightDate());
			f.setArrivalTime(flight.getArrivalTime());
			f.setDepartureTime(flight.getDepartureTime());
			f.setDiscount(flight.getDiscount());
			return f;
		}).orElseThrow(() -> new ResourceNotFoundException("Flight Schedule", "Id", id));
		LOG.info("Rescheduling flight");

		return scheduleRepo.save(upflight);
	}

	// Get the flight on schedules
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<FlightSchedule> retriveAllFlightsByDate(String src, String dest, Date journeyDate) {
		/*
		 * List<FlightSchedule> flights = scheduleRepo.
		 * findAllByflightDateEqualsAndFlightSrcAirportNameAndFlightDestAirportName(
		 * journeyDate,src,dest);
		 */
		List<FlightSchedule> flightss = scheduleRepo.getAllFlights(src,dest,journeyDate);
		return flightss;
	}

	// only accessible for admin side
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<FlightSchedule> retriveAllFlightOnSchedule() {
		return scheduleRepo.findAll();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<FlightSchedule> retriveAllFlightsByActiveArline() {
		return scheduleRepo.findAllByflightAirlineActive(true);
	}
	
	// Get the flight on schedule by id
	public FlightSchedule retriveFlightById(@Valid Long id) throws ResourceNotFoundException, Exception {
		return scheduleRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Flight Schedule", "Id", id));
	}

	// Delete the flight on schedule
	@Transactional(propagation = Propagation.REQUIRED)
	public void RemoveFlight(long id) throws ResourceNotFoundException {
		if (scheduleRepo.existsById(id))
			scheduleRepo.deleteById(id);
		else
			new ResourceNotFoundException("Flight Schedule", "Id", id);
	}

}
