package com.nt.service;

import java.util.List;

import com.nt.DTO.VehicleDTO;
import com.nt.entity.Booking;

public interface IBookingService {

	public Booking createBooking(Long vehicleId,String customerName,Integer days) throws Exception;
	public Booking getBookingDetails(Long bookingId) throws Exception;
	public List<Booking> getAllBooking() throws Exception;
	public List<VehicleDTO> checkAllVehicle() throws Exception;
	public List<VehicleDTO> checkAllAvaibleVehicle()throws Exception;
}
