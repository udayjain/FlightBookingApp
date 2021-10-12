package com.flightapp.admin.config;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AdminConfig {

	
	  @Bean 
	  public RestTemplate scheduleClient() {
		  return new RestTemplate(); 
	  }
	 
}
