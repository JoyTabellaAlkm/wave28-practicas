package com.example.seguros.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "siniestros")
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fecha;
    private Double perdidaEconomica;

    @ManyToOne
    @JoinColumn(name="vehiculo_id", nullable = false)
    private Vehiculo vehiculoDenunciado;
}
