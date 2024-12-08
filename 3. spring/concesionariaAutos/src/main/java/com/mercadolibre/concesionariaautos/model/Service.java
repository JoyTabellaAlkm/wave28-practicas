package com.mercadolibre.concesionariaautos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Service {

    private LocalDate date;
    private Double kilometers;
    private String descriptions;
}
