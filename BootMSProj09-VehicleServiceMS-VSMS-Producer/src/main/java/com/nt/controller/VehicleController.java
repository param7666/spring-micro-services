package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.entity.Vehicle;
import com.nt.service.IVehicleService;


@RestController
@RequestMapping("/vehicles")  // Base path for all endpoints
@RefreshScope
public class VehicleController {

	@Autowired
	private IVehicleService ser;
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getVehicleById(@PathVariable Long id) {
		Vehicle v=ser.getVehicleById(id);
		return new ResponseEntity<Vehicle>(v,HttpStatus.OK);
	}
	
	@GetMapping("/avaible")
	public ResponseEntity<List<Vehicle>> getAllAvaibleVehicle(){
		List<Vehicle> vlist=ser.getAllAvailableVehicle();
		return new ResponseEntity<List<Vehicle>>(vlist,HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}/{status}")
	public ResponseEntity<String> updateVehicleStatus(@PathVariable Long id,@PathVariable Boolean status) {
		String result=ser.updateAvailibilty(id, status);
		return new ResponseEntity<String>(result,HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addVehicle(@RequestBody Vehicle v) {
		String msg=ser.addVehicle(v);
		 return ResponseEntity.ok(msg);
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Vehicle>> getAllVehicle(){
		return new ResponseEntity<List<Vehicle>>(ser.getAllVehicle(),HttpStatus.OK);
	}
}
