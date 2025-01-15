package com.mercadolibre.showroom.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClothingDTO {
    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;
    private Integer stock;
    private BigDecimal price;
}
