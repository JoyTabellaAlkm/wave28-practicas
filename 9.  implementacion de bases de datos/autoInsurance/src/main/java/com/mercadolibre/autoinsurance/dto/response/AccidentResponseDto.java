package com.mercadolibre.autoinsurance.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccidentResponseDto {
    private Long id;
    @JsonProperty("date_of_accident")
    private LocalDate dateOfAccident;
    @JsonProperty("economic_loss")
    private Double economicLoss;
    @JsonProperty("vehicle_id")
    private Long vehicleId;
}
