package com.nt.ms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.BillClientComponantService;

@RestController
@RequestMapping("/shoping--api")
public class ShopingOperationMs {

	@Autowired
	private BillClientComponantService ser;
	
	@GetMapping("/buy")
	public ResponseEntity<String> doShoping(){
		String msg="Condom Packet + Rasian purchesed..";
		ResponseEntity<String> resp=ser.invokeDoBilling();
		System.out.println(resp);
		String result=msg+"......"+resp.getBody();
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
}
