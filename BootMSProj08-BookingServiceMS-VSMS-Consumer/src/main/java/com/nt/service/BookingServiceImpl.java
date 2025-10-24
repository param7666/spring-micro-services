package com.nt.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nt.IBookingRepository;
import com.nt.DTO.VehicleDTO;
import com.nt.client.VehicleClientComponanat;
import com.nt.entity.Booking;

@Service
public class BookingServiceImpl implements IBookingService{
	
	@Autowired
	private VehicleClientComponanat com;
	@Autowired
	private IBookingRepository repo;

	@Override
	@Transactional
	public Booking createBooking(Long vehicleId, String customerName, Integer days) throws Exception {
			VehicleDTO vehicle=null;
		try {
			vehicle =com.getVehicleById(vehicleId);
		} catch(Exception e) {
            throw new RuntimeException("Vehicle Service is currently unavailable. Please try again later.", e);
		}
		
		if(vehicle==null) throw new RuntimeException("Vehicle with "+vehicleId+" number is not found");
		
		//if(!vehicle.getAvailability()) throw new RuntimeException("Vehicle is not available please find another vehicle");
		
		if(days<=0) throw new RuntimeException("Days should be > 0");
		
		if(vehicleId==null || customerName==null) throw new RuntimeException("Vehicleid and customer name should not be empty");
		
		Double totalBalance=days*vehicle.getPricePerDay();
		Booking booking=new Booking(vehicleId, customerName, days, totalBalance);
		booking.setStatus("COMPLETED");
		Booking booked=repo.save(booking);
		
		try {
			com.updateVehicleStauts(vehicleId, false);
		} catch (Exception e) {
			throw new RuntimeException("Exception at updating status....");
		}
		return booked;
	}

	@Override
	public Booking getBookingDetails(Long bookingId) throws Exception {
		return repo.findById(bookingId).orElseThrow(()->new IllegalArgumentException("Booking Not Found..."));
	}

	@Override
	public List<Booking> getAllBooking() {
		List<Booking> allbooking=null;
		try {
			 allbooking=repo.findAll();
		} catch(Exception e) {
			throw new RuntimeException("Error at getting all bookings..");
		}
		return allbooking;
	}

	@Override
	public List<VehicleDTO> checkAllVehicle() throws Exception {
		
		List<VehicleDTO> vehicleList=null;
		try {
			vehicleList=new ArrayList<>();
			vehicleList=com.getAllVehicle();
		} catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error genereted to fetch Vehicle details");
		}
		
		if(vehicleList.isEmpty()) throw new RuntimeException("No vehicles Present");
		return vehicleList;
	}

	@Override
	public List<VehicleDTO> checkAllAvaibleVehicle() {
		List<VehicleDTO> vehicleList=null;
		try {
			vehicleList=new ArrayList<>();
			vehicleList=com.getAllAvailbleVehicle();
		} catch(Exception e) {
			e.printStackTrace();
			throw new RuntimeException("Error genereted to fetch Vehicle details");
		}
		
		if(vehicleList.isEmpty()) throw new RuntimeException("No vehicles are availble");
		return vehicleList;
	
	}

	
}
