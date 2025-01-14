package com.melibootcamp.empresadeseguros.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
public class Siniestro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;
    @Column(columnDefinition = "DATETIME", name = "fecha_de_siniestro")
    @JsonFormat(pattern = "dd-MM-yyyy")
    @JsonProperty("fecha_siniestro")
    private LocalDate fechaSiniestro;
    @Column(name = "perdida_economica")
    @JsonProperty("perdida_economica")
    private Double perdidaEconomica;

    @ManyToOne()
    @JoinColumn(name = "vehiculo_id")
    private Vehiculo vehiculoAsignado;
}
