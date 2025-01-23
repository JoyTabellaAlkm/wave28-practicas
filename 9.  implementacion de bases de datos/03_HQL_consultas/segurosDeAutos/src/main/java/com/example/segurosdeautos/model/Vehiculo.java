package com.example.segurosdeautos.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "vehiculos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "patente")
    private String patente;
    @Column(name = "marca")
    private String marca;
    @Column(name = "modelo")
    private String modelo;
    @Column(name = "anio_fabricacion")
    private LocalDate anioFabricacion;
    @Column(name = "cantidad_ruedas")
    private int cantidadRuedas;
    @OneToMany(mappedBy = "vehiculo",cascade = CascadeType.ALL)
    private List<Siniestro> siniestros;

}
