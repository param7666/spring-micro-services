package com.nt.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VehicleDTO {
    
    private Long vehicleId;
    private String vehicleName;
    private String type;
    private Double pricePerDay;
    private Boolean availability;
}
