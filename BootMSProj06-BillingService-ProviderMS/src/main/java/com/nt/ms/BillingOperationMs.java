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
public class BillingOperationMs {

	@Value("${spring.appication.instanceId}")
	private String instanceId;
	@Value("${server.port}")
	private Integer port;
	
	@GetMapping("/bill")
	public ResponseEntity<String> doBilling() {
		long billamt=new Random().nextLong(1000000);
		try {
			Thread.sleep(30000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<String>("Bill Amount is "+billamt+" instnace id is "+instanceId+" port number is"+port,HttpStatus.OK);
	}
}
