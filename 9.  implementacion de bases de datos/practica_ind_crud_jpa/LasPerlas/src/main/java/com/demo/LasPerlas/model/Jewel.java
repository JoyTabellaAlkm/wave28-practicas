package com.demo.LasPerlas.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Data
@Entity
public class Jewel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="nombre")
    private String name;
    private String material;
    @Column(name="peso")
    private Double weight;
    @Column(name="particularidad")
    private String particularity;
    @Column(name="posee_piedra")
    private Boolean hasStone;
    @Column(name="ventaONo")
    private boolean saleOrNot = true;
}
