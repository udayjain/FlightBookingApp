package com.flightapp.user.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1.0/flight/users")
public class UserController {


		//POST /api/v1.0/flight/search Searches for flight
		
		//POST /api/v1.0/flight/booking/{flightid} Book ticket

		//GET /api/v1.0/flight/ticket/{pnr} Get Booked ticket details based on PNR

		//GET /api/v1.0/flight/booking/history/{emailId} Get Booked tickets history based on Email ID

		//DELETE /api/v1.0/flight/booking/cancel/{pnr}

}
