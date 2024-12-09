package com.bootcamp.concesionaria.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Service {
    private Long id;
    private LocalDate date;
    private double kilometers;
    private String descriptions;
}
