package com.nt.ms;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/billing-api")
public class BillngServiceController {

	@Value("${eureka.application.instance.id}")
	private String instanceId;
	
	@GetMapping("/bill")
	public ResponseEntity<String> billingService(){
		System.out.println("BillngServiceController.billingService()");
		long billamt=new Random().nextLong(1000000);
		return new ResponseEntity<String>("bill Amount "+billamt+" instance id "+instanceId, HttpStatus.OK);
	}
}
