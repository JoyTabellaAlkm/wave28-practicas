package com.mercadolibre.showroom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleDTO {
    BigDecimal total;
    private String paymentMethod;
    private Map<Long, Integer> clothingQuantities;
}
