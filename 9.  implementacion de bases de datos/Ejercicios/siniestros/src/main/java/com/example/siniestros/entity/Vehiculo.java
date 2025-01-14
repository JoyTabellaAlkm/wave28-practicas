package com.example.siniestros.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

@Table(name = "vehiculos")
public class Vehiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String patente;
    String marca;
    String modelo;
    @Column(name = "anio_fabricacion")
    int añoFabricacion;
    @Column(name = "cant_ruedas")
    int cantRuedas;
    @OneToMany(mappedBy = "vehiculo")
    List<Siniestro> siniestros;
}
