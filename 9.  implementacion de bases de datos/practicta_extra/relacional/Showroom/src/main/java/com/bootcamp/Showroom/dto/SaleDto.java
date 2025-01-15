package com.bootcamp.Showroom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaleDto {
    private Integer number;
    private LocalDate date;
    private Double total;
    private String paymentMethod;
}
