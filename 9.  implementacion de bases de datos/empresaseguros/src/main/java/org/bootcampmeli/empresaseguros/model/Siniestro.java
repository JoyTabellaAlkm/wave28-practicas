package org.bootcampmeli.empresaseguros.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;


import java.time.LocalDate;
import java.util.Date;

@Entity
@Getter
@Data
public class Siniestro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @Column(name = "fecha_siniestro")
    @JsonProperty("fecha_siniestro")
    private LocalDate fechaSiniestro;

    @Column(name = "perdida_economica")
    @JsonProperty("perdida_economica")
    private double perdidaEconomica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vehiculo", nullable = false)
    private Vehiculo vehiculo;

}
