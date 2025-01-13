package com.dario.dominguez.practicaconcesionaria.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Vehicle implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String brand;
    private String model;
    @JsonFormat(pattern = "yyyy-MM-dd")  // Especifica solo el formato de fecha
    private Date manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    @OneToMany(mappedBy = "vehicle", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VService> services;
    private String countOfOwners;
}

