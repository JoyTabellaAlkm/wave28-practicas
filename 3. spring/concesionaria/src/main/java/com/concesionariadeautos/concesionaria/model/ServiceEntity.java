package com.concesionariadeautos.concesionaria.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServiceEntity {
    private LocalDate date;
    private Integer kilometers;
    private String description;
}
