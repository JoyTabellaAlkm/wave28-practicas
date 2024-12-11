package com.mercadoLibre.concesionariaAutos.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServiceDto {
    private String date;
    private String kilometers;
    private String descriptions;
}
