package com.bootcamp.concesionariaautos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Service {
    private Long id;
    private LocalDate date;
    private Double km;
    private String description;
}
