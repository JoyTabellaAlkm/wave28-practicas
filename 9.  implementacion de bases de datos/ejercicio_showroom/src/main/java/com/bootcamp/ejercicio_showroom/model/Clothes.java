package com.bootcamp.ejercicio_showroom.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@Entity
public class Clothes {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(unique = true, nullable = false)
    private String code;
    private String name;
    private String type;
    private String brand;
    private String color;
    private String size;
    private int quantity;
    private Double price;
}