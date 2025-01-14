package com.seguros_de_autos.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "vehiculo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String patente;
    private String marca;
    private String modelo;

    @Column(name = "ano_de_fabricacion")
    private int anoDeFabricacion;

    @Column(name = "cantidad_de_ruedas")
    private int cantidadDeRuedas;

    @OneToMany(mappedBy = "vehiculo")
    private Set<Siniestro> siniestros;
}
