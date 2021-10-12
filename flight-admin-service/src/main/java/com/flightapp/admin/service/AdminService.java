package com.flightapp.admin.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.flightapp.admin.exception.ResourceNotFoundException;
import com.flightapp.admin.modal.Airline;
import com.flightapp.admin.repository.AdminRespository;
import com.flightapp.admin.repository.AirlineRepository;

@Service
public class AdminService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminService.class);
	
	
	private AdminRespository adminRespository;
	
	
}
