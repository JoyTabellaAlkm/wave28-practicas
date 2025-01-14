package com.mercadolibre.autoinsurance.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatentBrandResponseDto {

    private String patent;
    @JsonProperty("year_of_manufacture")
    private String yearOfManufacture;

}
