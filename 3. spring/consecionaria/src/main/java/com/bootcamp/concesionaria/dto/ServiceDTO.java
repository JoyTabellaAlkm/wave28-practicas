package com.bootcamp.concesionaria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ServiceDTO {
    private String date;
    private double kilometers;
    private String descriptions;
}
