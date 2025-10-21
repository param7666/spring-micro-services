package com.nt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nt.client.BookClientService;

@RestController
@RequestMapping("/student-api")
public class BookController {

	@Autowired
	private BookClientService ser;
	
	@GetMapping("/borrow")
	public ResponseEntity<String> borrowBook(@RequestParam String bookName) {
		System.out.println("BookController.borrowBook()");
		String studentMsg = "Student wants to borrow: " + bookName;
		ResponseEntity<String> res=ser.invokeGetBook(bookName);
		String result=studentMsg+"....."+(res == null ? "No response from library" : res.getBody());
		System.out.println(result);
		return new ResponseEntity<String>(result,HttpStatus.OK);
		
	}
	
	@GetMapping("/view-all")
	public ResponseEntity<String> viewAllBooks() {
		System.out.println("BookController.viewAllBooks()");
		ResponseEntity<String> libResp = ser.invokeGetBooks();
		String body = libResp.getBody();
		String resp = "Available Books in Library: " + (body == null ? "No response" : body);
		System.out.println(resp);
		return ResponseEntity.status(libResp.getStatusCode()).body(resp);
		
	}
	
}
