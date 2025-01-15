package com.mercadolibre.siniestros.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String patente;
    private String marca;
    private String modelo;
    @Column(name = "anio_fabricacion")
    private int añoFabricacion;
    @Column(name = "cant_ruedas")
    private int cantRuedas;
    @OneToMany(mappedBy = "vehiculo")
    @JsonIgnore
    private List<Siniestro> siniestros;
}
