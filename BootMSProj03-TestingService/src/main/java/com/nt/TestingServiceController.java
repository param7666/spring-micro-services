package com.nt;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class TestingServiceController {

	@GetMapping("/msg")
	public ResponseEntity<String> testMessage() {
		System.out.println("TestingServiceController.testMessage()");
		return new ResponseEntity<String>("Your MicroService is running well",HttpStatus.OK);
	}
}
