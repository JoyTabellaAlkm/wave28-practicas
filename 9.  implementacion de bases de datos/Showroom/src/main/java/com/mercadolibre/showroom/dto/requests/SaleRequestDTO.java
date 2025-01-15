package com.mercadolibre.showroom.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaleRequestDTO {
    BigDecimal total;
    private String paymentMethod;
    private Map<Long, Integer> clothingQuantities;
}
