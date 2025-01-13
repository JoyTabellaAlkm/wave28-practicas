package com.mercadolibre.concesionario.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.print.attribute.standard.MediaSize;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "vehicles")
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String brand;
    private String model;
    private LocalDate manufacturingDate;
    private String numberOfKilometers;
    private String doors;
    private String price;
    private String currency;
    private String countOfOwners;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "vehicles_services",
            joinColumns = @JoinColumn(name = "vehicles_id"),
            inverseJoinColumns = @JoinColumn(name = "services_id")
    )
    private List<Services> services;
}
