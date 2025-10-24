package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nt.entity.Booking;
import com.nt.service.IBookingService;

@RestController
@RequestMapping("/booking")
@RefreshScope
public class BookingController {
	
	@Autowired
	private IBookingService ser;

    

	@PostMapping("/create/{vehicleId}/{customerName}/{days}")
	public ResponseEntity<?> createBooking(@PathVariable("vehicleId") Long vehicleId,@PathVariable("customerName") String customerName,@PathVariable("days") Integer numOfDays){
		System.out.println("BookingController.createBooking()");
		try {
			Booking b=ser.createBooking(vehicleId, customerName, numOfDays);
			return new ResponseEntity<Booking>(b,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/check/{vehicleId}")
	public ResponseEntity<?> checkBookingDetails(@PathVariable("vehicleId") Long vehicleId){
		System.out.println("BookingController.checkBookingDetails()" +vehicleId);
		try {
			Booking b=ser.getBookingDetails(vehicleId);
			return new ResponseEntity<Booking>(b,HttpStatus.OK);
		} catch(Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping("/check-allbooking")
	public ResponseEntity<?> checkAllBookings(){
		System.out.println("BookingController.checkAllBookings()");
		try {
			List<Booking> list=ser.getAllBooking();
			return new ResponseEntity<List<Booking>>(list,HttpStatus.OK);

		}catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
