package com.bootcamp.vehiculos.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String patente;
    @Column
    private String marca;
    @Column
    private String modelo;
    @Column(name = "anio_fabricacion")
    private int anioFabricacion;
    @Column(name = "cantidad_ruedas")
    private int cantidadRuedas;
    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL)
    private List<Siniestro> siniestros;
}
