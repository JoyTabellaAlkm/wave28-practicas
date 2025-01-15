package com.mercadolibre.showroom.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ClothingDTO {
    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;
    private Integer stock;
    private BigDecimal price;
}
