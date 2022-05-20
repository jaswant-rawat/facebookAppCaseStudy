package com.capgemini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MarketPlaceServiceFbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketPlaceServiceFbApplication.class, args);
	}

}
