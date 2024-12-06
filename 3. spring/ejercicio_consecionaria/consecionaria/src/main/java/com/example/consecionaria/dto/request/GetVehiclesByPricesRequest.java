package com.example.consecionaria.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class GetVehiclesByPricesRequest {
    private double since;
    private double to;
}
