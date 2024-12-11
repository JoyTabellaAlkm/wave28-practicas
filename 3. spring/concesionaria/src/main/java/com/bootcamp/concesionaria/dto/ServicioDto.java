package com.bootcamp.concesionaria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicioDto {
    public LocalDate date;
    public String kilometers;
    public String descriptions;
}
