package com.mercadolibre.jewelry.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "jewels")
public class Jewel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String name;
    @Column(nullable = false, length = 100)
    private String material;
    @Column(nullable = false)
    private Double weight;
    private String particularity;
    @Column(name = "has_stone", nullable = false)
    private Boolean hasStone;
    @Column(name = "sale_or_not", columnDefinition = "boolean default true")
    private Boolean saleOrNot = true;

}
