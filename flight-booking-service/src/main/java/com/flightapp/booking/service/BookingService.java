package com.flightapp.booking.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flightapp.booking.exception.ResourceNotFoundException;
import com.flightapp.booking.modal.Booking;
import com.flightapp.booking.repository.BookingRepository;

@Service
public class BookingService {
	private static final Logger LOG = LoggerFactory.getLogger(BookingService.class);
	
	@Autowired
	private BookingRepository bookingRepository;
	
	public ResponseEntity<?> bookTicket(Booking booking) throws ResourceNotFoundException{
		
		
		
		return ResponseEntity.ok("Ticket Booked Successfully!");
	}
}
