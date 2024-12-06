package com.example.ejerciciocovid.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SintomaDto {
    private String nombre;
    private int nivelDeGravedad;
}
