package com.nt.ms;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.IBillingComponant;

@RestController
@RequestMapping("/shoping-api")
public class ShopingOperationMS {

	@Autowired
	private IBillingComponant com;
	
	@GetMapping("/buy")
	public ResponseEntity<String> doShoping(){
		System.out.println("Client Componant proxy class Name  "+com.getClass());
		System.out.println("Client Compont Class Implemented Interfaces  "+Arrays.toString(com.getClass().getInterfaces()));
		System.out.println("Client componants clss methods "+Arrays.toString(com.getClass().getDeclaredMethods()));
		
		String msg= "Shirt, Trouser  items are purchased  ";
	    //invoke  Target MS endpoing through  client comp
	    ResponseEntity<String> resp=com.invokeDoBilling();
	    //generate the final result
	    String result=msg+"...."+resp.getBody();
	    //return ResponseEntity object
	    return new ResponseEntity<String>(result,HttpStatus.OK);
	}
}
