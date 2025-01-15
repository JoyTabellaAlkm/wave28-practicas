package com.bootcamp.clothes.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class SaleDTO {
    private LocalDate date;
    private Double total;
    private String paymentMethod;
    private List<Long> clothesIds;
}