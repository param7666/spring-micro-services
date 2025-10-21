package com.nt.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/library-api")
public class BookController {

	@Value("${eureka.instance.instance-id}")
	private String instanceId;
	
	@GetMapping("/book")
	public ResponseEntity<String> getBookInfo(@RequestParam String bookName) {
		System.out.println("BookController.getBookInfo()  "+bookName);
		System.out.println("BookController.getBookInfo()===="+bookName);
		return new ResponseEntity<String>("Book "+bookName+" is available, Intance=="+instanceId, HttpStatus.OK);
	}
	
	
	@GetMapping("/books")
	public ResponseEntity<String>  getAllBooks(){
		System.out.println("BookController.getAllBooks()");
		return ResponseEntity.ok("Books: Java, Python, Spring Boot | Instance: " + instanceId);
	}

	
}
