package com.nt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

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

@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor
@Entity
@Table(name="booking100")
public class Booking {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookingId;
	@Nonnull
	private Long vehicleId;
	@Nonnull
	private String customerName;
	@Nonnull
	private Integer numOfDays;
	@Nonnull
	private Double totalCost;// Calculated: days × pricePerDay

	@Column(nullable = false)
	@CreationTimestamp
	private LocalDateTime bookingDate;  // When booking was created
	
	private String status;  // CONFIRMED, CANCELLED, COMPLETED

}

//🧠 Entity: Booking
//Field		Type	Description
//bookingId	Long	Unique Booking ID
//vehicleId	Long	Vehicle linked to booking
//customerName	String	Customer making booking
//days		Integer	Number of days
//totalCost	Double	Computed total price