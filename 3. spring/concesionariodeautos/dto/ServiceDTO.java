package com.mercadolibre.concesionariodeautos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceDTO {
    private String date;
    private String kilometers;
    private String descriptions;
}