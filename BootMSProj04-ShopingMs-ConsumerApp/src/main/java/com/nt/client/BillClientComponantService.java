package com.nt.client;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


@Component
public class BillClientComponantService {

	@Autowired
	private DiscoveryClient client;
	
	public ResponseEntity<String> invokeDoBilling(){
		//get  target  MS   service Instance from the Eureka Server
		List<ServiceInstance> listSi=client.getInstances("BootMSProj04-BillingService");
		
		// get endpoint details of target ms
		URI url=listSi.get(0).getUri();
		 //complete  the URL
		String complateUrl=url+"/billing-api/bill";
		
		//RestTemplete obj
		
		RestTemplate template=new RestTemplate();
		
		// invoke the target ms endpoint
		
		ResponseEntity<String> resp=template.exchange(complateUrl, HttpMethod.GET,null, String.class);
		return resp;
	}
}
