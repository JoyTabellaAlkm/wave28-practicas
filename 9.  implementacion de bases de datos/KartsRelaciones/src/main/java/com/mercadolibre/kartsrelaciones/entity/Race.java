package com.mercadolibre.kartsrelaciones.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.Set;

@Getter @Setter
@Entity
@Table(name = "races")
public class Race {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private LocalDate fecha;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pais_id")
    private Country pais;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
        name = "race_pilot",
        joinColumns = @JoinColumn(name = "race_id"),
        inverseJoinColumns = @JoinColumn(name = "pilot_id")
    )
    private Set<Pilot> pilotos;
}