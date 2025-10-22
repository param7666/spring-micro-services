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
	@Value("${username}")
	private String username;
	@Value("${password}")
	private String password;
	
	public BillingOperationMs() {
		System.out.println("BillingOperationMs.BillingOperationMs()");
	}
	
	@GetMapping("/bill")
	public ResponseEntity<String> doBilling(){
		System.out.println("BillingOperationMs.doBilling()");
		Long billamt=new Random().nextLong(1000000);
		return new ResponseEntity<String>("Bill Amount is= "+billamt+" instance id= "+instanceId+
				" port number= "+port+" username= "+username+" password= "+password, HttpStatus.OK);
	}
}
