package com.seguros_de_autos.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "siniestro")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Siniestro {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private LocalDate fechaDelSiniestro;
    private double perdidadEconomica;

    @ManyToOne
    @JoinColumn(name = "vehiclo_id", nullable = false)
    private Vehiculo vehiculo;
}
