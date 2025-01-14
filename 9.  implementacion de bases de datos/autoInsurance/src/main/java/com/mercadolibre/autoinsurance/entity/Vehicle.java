package com.mercadolibre.autoinsurance.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 15, unique = true)
    private String patent;
    @Column(nullable = false, length = 30)
    private String brand;
    @Column(nullable = false, length = 50)
    private String model;
    @Column(name = "year_of_manufacture", nullable = false)
    private Short yearOfManufacture;
    @Column(name = "number_of_wheels", nullable = false)
    private Byte numberOfWheels;
    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Accident> accidents = new ArrayList<>();

}
