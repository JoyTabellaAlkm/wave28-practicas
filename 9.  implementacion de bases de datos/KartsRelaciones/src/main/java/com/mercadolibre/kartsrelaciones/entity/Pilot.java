package com.mercadolibre.kartsrelaciones.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter @Setter
@Entity
@Table(name = "pilots")
public class Pilot {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private int edad;

    @OneToOne(mappedBy = "piloto", cascade = CascadeType.ALL)
    private Kart kart;

    @ManyToMany(mappedBy = "pilotos", cascade = CascadeType.PERSIST)
    private Set<Race> carreras;
}