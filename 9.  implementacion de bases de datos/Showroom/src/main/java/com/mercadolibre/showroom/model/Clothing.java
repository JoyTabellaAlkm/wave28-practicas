package com.mercadolibre.showroom.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "clothing")
@Data
public class Clothing {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;

    private Integer stock;
    private BigDecimal price;


}
