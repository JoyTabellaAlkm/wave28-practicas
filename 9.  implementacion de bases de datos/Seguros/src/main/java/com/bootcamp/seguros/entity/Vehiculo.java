package com.bootcamp.seguros.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String patente;

    private String marca;

    private String modelo;

    @Column(name = "anio_de_fabricación")
    private int anioDeFabricación;

    @Column(name = "cantidad_de_ruedas")
    private int cantidadDeRuedas;
}
