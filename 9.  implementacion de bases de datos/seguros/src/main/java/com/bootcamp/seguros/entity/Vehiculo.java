package com.bootcamp.seguros.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String patente;
    private String marca;
    private String modelo;
    private int anio;
    private int ruedas;

    @OneToMany(mappedBy = "vehiculo")
    private Set<Siniestro> siniestro;
}
