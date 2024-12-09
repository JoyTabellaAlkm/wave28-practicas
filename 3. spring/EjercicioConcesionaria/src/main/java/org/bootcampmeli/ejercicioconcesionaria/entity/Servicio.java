package org.bootcampmeli.ejercicioconcesionaria.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class Servicio {
    private LocalDate date;
    private Integer kilometers;
    private String descriptions;
}