package com.nt.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nt.DTO.VehicleDTO;

@FeignClient(name="BootMSProj08-VehicleServiceMS-VSMS-Producer",path = "/vehicles")
public interface VehicleClientComponanat {

	@GetMapping("/{id}")
	public VehicleDTO getVehicleById(@PathVariable("id") Long id);
	
	@GetMapping("/avaible")
	public List<VehicleDTO> getAllAvailbleVehicle();
	
	@PutMapping("/update/{id}/{status}")
	public ResponseEntity<String> updateVehicleStauts(@PathVariable("id")Long id,@PathVariable("status")Boolean status);
	
	@PostMapping("/add")
	public ResponseEntity<String> addVehicle(@RequestBody VehicleDTO dto);
	
	@GetMapping("/all")
	public List<VehicleDTO> getAllVehicle();
	
}
