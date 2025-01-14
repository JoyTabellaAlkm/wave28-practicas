package com.bootcamp.SegurosAutos.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String patente;
    String marca;
    String modelo;
    LocalDate fabricacion;
    @Column(name="cantidad_ruedas")
    Integer cantidadRuedas;
    @OneToMany(mappedBy = "vehiculo") // bidireccional
    Set<Siniestro> siniestros;
}
