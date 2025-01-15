package com.bootcamp.seguros.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fecha;

    @Column(name = "perdida_economica")
    private double perdidaEconomica;

    @ManyToOne
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculoDenunciado;
}
