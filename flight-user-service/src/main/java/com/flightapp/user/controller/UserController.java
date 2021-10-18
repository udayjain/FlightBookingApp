package com.flightapp.user.controller;


import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flightapp.user.payload.request.SearchFlight;

@RestController
@RequestMapping("/api/v1.0/flight/users")
public class UserController {


		//POST /api/v1.0/flight/search Searches for flight
		@PostMapping("/search")
		public List<Object> findFlights(@RequestBody SearchFlight searchflight) {
			return new ArrayList<>();
		}
		
		

		//POST /api/v1.0/flight/booking/{flightid} Book ticket
		@GetMapping("/booking/{flightid}")
		public ResponseEntity<?> bookFlight(@RequestBody Object bookingModal , @PathVariable Long flightid){
			
			return null;
			
		}
		//GET /api/v1.0/flight/booking/history/{emailId} Get Booked tickets history based on Email ID
		@GetMapping("/booking/history/{emailId}")
		public ResponseEntity<?> myBookingHistory(@PathVariable @Email String emailId){
			
			return null;
			
		}
		//GET /api/v1.0/flight/ticket/{pnr} Get Booked ticket details based on PNR
		@GetMapping("/booking/ticket/{pnr}")
		public ResponseEntity<?> retriveBookingDetails(@PathVariable String pnr){
			
			return null;
			
		}
		//DELETE /api/v1.0/flight/booking/cancel/{pnr}
		@DeleteMapping("/booking/cancel/{pnr}")
		public ResponseEntity<?> cancelBooking(@PathVariable String pnr){
			
			return null;
			
		}
}
