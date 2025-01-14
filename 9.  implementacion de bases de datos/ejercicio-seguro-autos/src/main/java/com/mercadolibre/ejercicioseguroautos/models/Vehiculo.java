package com.mercadolibre.ejercicioseguroautos.models;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String patente;
    private String marca;
    private String modelo;

    @Column(name = "fecha_fabricacion")
    private LocalDate fechaFabricacion;

    @Column(name = "cantidad_de_ruedas")
    private Integer cantidadDeRuedas;

    @OneToMany(mappedBy = "vehiculo", cascade = CascadeType.ALL)
    private List<Siniestro> siniestros;

}
