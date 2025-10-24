package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BootMsProj08EurekaServerMsVsmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj08EurekaServerMsVsmsApplication.class, args);
		System.out.println("🚀 Eureka Server started on port 8761");

	}

}
