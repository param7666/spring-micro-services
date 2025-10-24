package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class BootMsProj08ConfigServerMsVsmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj08ConfigServerMsVsmsApplication.class, args);
		 System.out.println("🚀 Config Server started on port 8888");
	     System.out.println("📁 Serving configurations from GitHub repository");
	    
	}

}
