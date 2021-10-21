package com.flightapp.admin.controller;

import java.sql.SQLDataException;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties.Admin;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.flightapp.admin.exception.ResourceNotFoundException;
import com.flightapp.admin.modal.Airline;
import com.flightapp.admin.modal.FlightSchedule;
import com.flightapp.admin.modal.UserDetails;
import com.flightapp.admin.payload.request.LoginRequest;
import com.flightapp.admin.repository.AdminRespository;
import com.flightapp.admin.service.AdminService;
import com.flightapp.admin.service.AirlineService;
import com.flightapp.admin.service.AirportService;
import com.flightapp.admin.service.ScheduleService;

@RestController
@RequestMapping("/app/v1.0/flight/admin")
public class AdminController {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminController.class);
	

	@Autowired
	private AirlineService airlineService;
	
	@Autowired
	private AirportService airportService; 	
	
	@Autowired
	private ScheduleService scheduleService;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	///POST /api/v1.0/flight/admin/login Admin login
	@PostMapping("/login")
	public ResponseEntity<?> signIn(@RequestBody LoginRequest loginrequest) {		
		
		boolean isAdmin = loginrequest.getUserName().equalsIgnoreCase("Admin") 
				&& loginrequest.getPassword().equalsIgnoreCase("AdminAdmin");
		
		return ResponseEntity.ok( isAdmin ? "Admin Login successfully" : "Admin not found!!"); 
	}
	
	// Get /api/v1.0/flight/airline/ get all airlines
	@GetMapping("/airline")
	public List<Airline> retriveAllAirlines() throws Exception{
		return airlineService.retriveAllAirline();
	}
	
	@GetMapping("/airline/{id}")
	public ResponseEntity<?> retriveAirlines(@PathVariable long id) throws ResourceNotFoundException, Exception{
		return ResponseEntity.ok(airlineService.retriveAirline(id));
	}
	
	//POST /api/v1.0/flight/airline/register New airline 
	@PostMapping("/airline")
	public ResponseEntity<?> createAirline(@Valid @RequestBody Airline airline) throws SQLDataException, Exception {
		
		LOGGER.info("Creating the Airline");
		Airline airlineCreated = airlineService.createAirline(airline);
		LOGGER.info("New Airline added successfully!");
		return ResponseEntity.status(HttpStatus.CREATED).body(airlineCreated);
	}
	
	@PutMapping("/airline/{id}")
	public ResponseEntity<?> updateAirline(@Valid @RequestBody Airline airline,@PathVariable long id) {
		
		LOGGER.info("Updating the Airline");
		Airline airlineUpdated = airlineService.updateAirline(airline, id);
		LOGGER.info("Airline updated successfully!");
		return ResponseEntity.status(HttpStatus.CREATED).body(airlineUpdated);
	}


	@DeleteMapping("/airline/{id}")
	public ResponseEntity<?> removeAirline(@PathVariable long id) throws ResourceNotFoundException, Exception {
		
		LOGGER.info("Deleting the Airline");
		
		LOGGER.info("Airline delete successfully!");
		return airlineService.removeAirline(id);
	}
	
	@PutMapping("/airline/block/{id}")
	public ResponseEntity<?> blockAirline(@PathVariable long id) throws ResourceNotFoundException, Exception {
		
		LOGGER.info("blocking the Airline");
		
		return airlineService.blockAirline(id);
	}
	
	@PutMapping("/airline/unblock/{id}")
	public ResponseEntity<?> unBlockAirline(@PathVariable long id) throws ResourceNotFoundException, Exception {
		
		LOGGER.info("Unblocking the Airline");
		
		return airlineService.unBlockAirline(id);
	}
	
	//POST /api/v1.0/flight/airline/inventory/add Add Inventory/Schedule of an existing Airline
	
	@PostMapping("/schedule/add")
	public ResponseEntity<?> scheduleFlight(@Valid @RequestBody FlightSchedule flightSchedule){			
		
		return scheduleService.addFlightOnSchedule(flightSchedule);
	}
	//POST /api/v1.0/flight/airline/inventory/add Add Inventory/Schedule of an existing Airline
	@PutMapping("/schedule/{id}")
	public ResponseEntity<?> rescheduleFlight(@Valid @RequestBody FlightSchedule flightSchedule, @PathVariable Long id){			
		
		return scheduleService.reschdeuleFlightOnSchedule(flightSchedule,id);
	}
	
	//POST /api/v1.0/flight/airline/inventory/remove Add Inventory/Schedule of an existing Airline
	@DeleteMapping("/schedule/{id}")
	public ResponseEntity<?> removeScheduleFlight(@PathVariable Long id){			
		
		return scheduleService.removeFlightOnSchedule(id);
	}
	
	@GetMapping("/schedule")
	public ResponseEntity<?> retriveAllScheduleFlight(){			
		
		return scheduleService.getAllFlightOnSchedule();
	}
	
	@GetMapping("/schedule/{id}")
	public ResponseEntity<?> retriveScheduleFlight(@PathVariable Long id){			
		
		return scheduleService.getFlightOnSchedule(id);
	}
		
}
