package com.cogni.uday.cloudgatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class CloudGatewayServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudGatewayServiceApplication.class, args);
	}

}
