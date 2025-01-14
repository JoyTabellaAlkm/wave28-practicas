package com.bootcamp.vehiculos.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "siniestros")
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "fecha_siniestro")
    private LocalDate fechaSiniestro;
    @Column(name = "perdida_economica")
    private double perdidaEconomica;
    @ManyToOne
    @JoinColumn(name = "vehiculo_id", nullable = false)
    @JsonIgnore
    private Vehiculo vehiculo;
}
