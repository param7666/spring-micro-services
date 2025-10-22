package com.nt.ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.IBillingMsServiceClientCom;

@RestController
@RequestMapping("/shoping-api")
public class ShopingOperationMs {

	@Autowired
	private IBillingMsServiceClientCom componant;
	
	@Value("${username}")
	private String username;
	@Value("${password}")
	private String password;
	
	public ShopingOperationMs() {
		System.out.println("ShopingOperationMs.ShopingOperationMs()");
	}
	
	@GetMapping("/buy")
	public ResponseEntity<String> doShoping() {
		String msg= "Shirt, Trouser  items are purchased db.user="+username+"..."+" db.pwd="+password;
		ResponseEntity<String> result=componant.invokeDoBilling();
		
		String finalOutput=msg+" "+result.getBody();
		return new ResponseEntity<String>(finalOutput,HttpStatus.OK);
	}
}
