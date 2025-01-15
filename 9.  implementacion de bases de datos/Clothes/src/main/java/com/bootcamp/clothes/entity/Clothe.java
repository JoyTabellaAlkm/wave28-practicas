package com.bootcamp.clothes.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "clothes")
public class Clothe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;

    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;
    private Integer quantity;

    @Column(name = "sale_price")
    private Double salePrice;
}
