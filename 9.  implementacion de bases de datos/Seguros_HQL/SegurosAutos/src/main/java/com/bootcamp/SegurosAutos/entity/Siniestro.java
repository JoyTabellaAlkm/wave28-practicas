package com.bootcamp.SegurosAutos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name="fecha_siniestro")
    LocalDate fechaSiniestro;
    @Column(name="perdida_economica")
    Double perdidaEconomica;
    @ManyToOne
    @JoinColumn(name="vehiculo_id", nullable = false)
    Vehiculo vehiculo;
}
