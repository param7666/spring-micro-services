package com.nt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nt.entity.Vehicle;
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long>{

	@Query("from Vehicle where vehicleId=?1")
	public Optional<Vehicle> findVehileByvehicleId(Long vehicleId);
	
	@Query("SELECT v FROM Vehicle v WHERE  v.availibilityStatus = true")
	public List<Vehicle> findAllAvaiblevehicles();
}
