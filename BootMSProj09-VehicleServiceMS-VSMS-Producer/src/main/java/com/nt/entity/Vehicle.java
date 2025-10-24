package com.nt.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@Table(name = "vehicles")
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor

public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long vehicleId;
	@Nonnull
	@Column(length = 30)
	private String vehicleName;
	@Nonnull
	@Column(length = 30)
	private String type;
	@Nonnull
	private Double pricePerDay;
	
	@Nonnull
	private Boolean availibilityStatus=true;
	
}
