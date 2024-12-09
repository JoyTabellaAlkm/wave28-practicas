package com.ejercicio.autos.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Servicio {

    private LocalDate date;
    private double kilometers;
    private String descriptions;
}
