package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient

public class BootMsProj08VehicleServiceMsVsmsProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj08VehicleServiceMsVsmsProducerApplication.class, args);
		System.out.println("🚗 Vehicle Service started successfully!");

	}

}
