package com.nt.client;

import java.net.URI;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BookClientService {

	@Autowired
	private DiscoveryClient client;
	
	RestTemplate template=new RestTemplate();


	
	public ResponseEntity<String> invokeGetBook(String bookName){
		System.out.println("BookClientService.invokeGetBook()");
		List<ServiceInstance> list=client.getInstances("BootMSProj05-Student-LibraryService-ProviderApp");
		if(list==null || list.isEmpty()) {
			System.out.println("BookClientService.invokeGetBook() is empty  " );
			return new ResponseEntity<String>("No Instance found...",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		int index = new Random().nextInt(list.size());
		URI uri=list.get(index).getUri();
		String completeUrl=uri+"library-api/book?bookName="+bookName;
		System.out.println("BookClientService.invokeGetBook() success");
		return template.exchange(completeUrl, HttpMethod.GET,null,String.class);
	}
	
	
	public ResponseEntity<String> invokeGetBooks(){
		System.out.println("BookClientService.invokeGetBooks() ENTERED");
		List<ServiceInstance> list=client.getInstances("BootMSProj05-Student-LibraryService-ProviderApp");
		if(list==null || list.isEmpty()) {
			System.out.println("BookClientService.invokeGetBooks() LIST IS NULL");
			return new ResponseEntity<String>("NO Instance Found...",HttpStatus.INTERNAL_SERVER_ERROR);
		}
		URI url=list.get(0).getUri();
		String comUrl=url+"/library-api/books";
		System.out.println("BookClientService.invokeGetBooks() SUCCESS");
		return template.exchange(comUrl, HttpMethod.GET,null,String.class);
	}
}
