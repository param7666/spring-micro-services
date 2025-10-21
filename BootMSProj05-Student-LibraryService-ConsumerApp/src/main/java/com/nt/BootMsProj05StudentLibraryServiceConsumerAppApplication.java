package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BootMsProj05StudentLibraryServiceConsumerAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj05StudentLibraryServiceConsumerAppApplication.class, args);
		System.out.println("BootMsProj05StudentLibraryServiceConsumerAppApplication.main()");
	}

}
