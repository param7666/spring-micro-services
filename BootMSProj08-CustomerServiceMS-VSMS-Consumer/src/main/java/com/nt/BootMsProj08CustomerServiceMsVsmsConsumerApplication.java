package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class BootMsProj08CustomerServiceMsVsmsConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj08CustomerServiceMsVsmsConsumerApplication.class, args);
		System.out.println("📋 Booking Service started successfully!");

	}

}
