package com.example.consecionaria.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class GetVehiclesByDateRequest {
    private LocalDate since;
    private LocalDate to;
}
