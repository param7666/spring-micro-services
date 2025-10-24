package com.nt.service;

import java.util.List;

import com.nt.entity.Vehicle;

public interface IVehicleService {

	public Vehicle getVehicleById(Long vehicleId);
	
	public List<Vehicle> getAllAvailableVehicle();
	
	public String updateAvailibilty(Long vehicleId, Boolean status);
	
	public String addVehicle(Vehicle v);
	
	public List<Vehicle> getAllVehicle();
}
