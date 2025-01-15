package com.example.seguros_api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty("id")
    private Long id;

    @JsonProperty("patente")
    @Column
    private String patente;

    @Column
    @JsonProperty("marca")
    private String marca;

    @Column
    @JsonProperty("modelo")
    private String modelo;

    @Column(name = "anio_fabricacion")
    @JsonProperty("anio_fabricacion")
    private Integer anioFabricacion;

    @Column(name = "cantidad_ruedas")
    @JsonProperty("cantidad_ruedas")
    private String cantidadRuedas;

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL)
    private List<Siniestro> siniestros;
}
