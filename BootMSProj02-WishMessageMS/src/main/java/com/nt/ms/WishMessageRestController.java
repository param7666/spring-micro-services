package com.nt.ms;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wish")
public class WishMessageRestController {

	@Value("${spring.application.name}")
	private String instanceId;
	
	@GetMapping("/msg")
	public ResponseEntity<String> getMessage() {
		System.out.println("WishMessageRestController.getMessage()");
		return new ResponseEntity<String>("Wellcome to WishMessage api  "+instanceId,HttpStatus.OK);
	}
}
