package com.bootcamp.ejercicio_concesionaria.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Service {
    private Long id;
    private LocalDate date;
    private String kilometers;
    private String descriptions;
}
