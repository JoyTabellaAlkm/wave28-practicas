package com.mercadolibre.ejercicioseguroautos.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "siniestro")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Siniestro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "fecha_siniestro")
    private LocalDate fechaSiniestro;

    @Column(name = "perdida_economica")
    private Double perdidaEconomica;

    @ManyToOne
    @JoinColumn(name = "id_vehiculo")
    private Vehiculo vehiculo;

    @Override
    public String toString() {
        return "Siniestro{" +
                "id=" + id +
                ", fechaSiniestro=" + fechaSiniestro +
                ", perdidaEconomica=" + perdidaEconomica +
                ", vehiculo=" + vehiculo +
                '}';
    }
}
