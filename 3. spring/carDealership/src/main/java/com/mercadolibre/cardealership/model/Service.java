package com.mercadolibre.cardealership.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Service {
    private Integer id;
    private LocalDate date;
    private Integer kilometers;
    private String descriptions;
}
