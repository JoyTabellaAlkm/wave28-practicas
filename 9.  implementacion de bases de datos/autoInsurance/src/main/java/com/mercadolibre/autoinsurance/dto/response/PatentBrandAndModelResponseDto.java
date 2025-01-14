package com.mercadolibre.autoinsurance.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatentBrandAndModelResponseDto {
    private String patent;
    private String brand;
    private String model;
}
