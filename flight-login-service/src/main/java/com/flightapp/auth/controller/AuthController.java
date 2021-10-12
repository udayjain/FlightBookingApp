package com.flightapp.auth.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.info.ProjectInfoProperties.Build;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.flightapp.auth.dto.JwtResponse;
import com.flightapp.auth.dto.LoginRequest;
import com.flightapp.auth.dto.MessageResponse;
import com.flightapp.auth.dto.SignUpRequest;
import com.flightapp.auth.modal.ERole;
import com.flightapp.auth.modal.Role;
import com.flightapp.auth.modal.User;
import com.flightapp.auth.repository.RoleRepository;
import com.flightapp.auth.repository.UserRepository;
import com.flightapp.auth.security.jwt.JwtUtils;
import com.flightapp.auth.security.services.UserDetailsImpl;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v.1/auth")
public class AuthController {
	private static final Logger LOG = LoggerFactory.getLogger(AuthController.class);
	
	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtUtils jwtUtils;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
		LOG.info("User started sign in");
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateJwtToken(authentication);
		
		UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();		
		
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		LOG.info("User sign in Successfully" + userDetails.getId());
		
		
		return ResponseEntity.ok(new JwtResponse (jwt, 
												 userDetails.getId(), 
												 userDetails.getUsername(), 
												 userDetails.getDisplayName(), 
												 roles));
		
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {

		if (userRepository.existsByEmailId(signUpRequest.getEmailId())) {
			
			return ResponseEntity.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}
		LOG.info("User sign up Process Started");
		// Create new user's account
		User user = new User();
		user.setEmailId(signUpRequest.getEmailId());
		user.setFirstName(signUpRequest.getFirstName());
		user.setLastName(signUpRequest.getLastName());
		user.setPassword(encoder.encode(signUpRequest.getPassword()));
		user.setDob(signUpRequest.getDob());
		user.setGender(signUpRequest.getGender());
		user.setMobNO(signUpRequest.getMobNo());
		user.setActive(true);
		LOG.info("User sign up Process in progress");
		Set<Role> roles = new HashSet<>();
	
		LOG.info("User sign up role save");
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is found."));
			roles.add(userRole);	
		

		user.setRoles(roles);
		LOG.info("User sign up role assign successfully");
		User newser = userRepository.save(user);
		LOG.info("User sign up Successfully");
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(new MessageResponse("Successfully register!!"));
	}
	
	@GetMapping("/admin")
	public List<User> retriveallUsers() {
		return userRepository.findAll();
	}
}
