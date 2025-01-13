package com.mercadolibre.concesionario.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Service {
    private LocalDate date;
    private String kilometers;
    private String descriptions;
}
