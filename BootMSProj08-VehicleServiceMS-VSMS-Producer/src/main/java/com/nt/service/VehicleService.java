package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Vehicle;
import com.nt.exception.VehicleNotFoundException;
import com.nt.repository.VehicleRepository;

@Service
public class VehicleService implements IVehicleService{
	
	@Autowired
	private VehicleRepository repo;

	@Override
	public Vehicle getVehicleById(Long vehicleId) {
		return  repo.findById(vehicleId).orElseThrow(()-> new VehicleNotFoundException("Vehicle not found "+vehicleId));
	}

	@Override
	public List<Vehicle> getAllAvailableVehicle() {
		return repo.findAllAvaiblevehicles();
	}

	@Override
	public String updateAvailibilty(Long vehicleId, Boolean status) {
		Optional<Vehicle> v=repo.findVehileByvehicleId(vehicleId);
		if(v.isPresent()) {
			Vehicle vehicle=v.get();
			vehicle.setAvailibilityStatus(status);
			repo.save(vehicle);
			return vehicle.getVehicleId()+" Vehicle status updated to "+vehicle.getAvailibilityStatus();
		}
		return "Vehicle with id "+vehicleId+" is not found";
	}

	@Override
	public String addVehicle(Vehicle v) {
		Long id=repo.save(v).getVehicleId();
		return "Vehile added with id "+v.getVehicleId();
	}

	@Override
	public List<Vehicle> getAllVehicle() {
		return repo.findAll();
	}

}
