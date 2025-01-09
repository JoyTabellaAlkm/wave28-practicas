package com.mercadolibre.social.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductSearchDto {
    private String name;
    private String type;
    private String brand;
    private String color;
    private String notes;
    private String date;
    private String category;
    private Double price;
    private Boolean hasPromo;
    private Double discount;
}
