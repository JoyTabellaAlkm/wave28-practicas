package com.mercadolibre.kartsrelaciones.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "karts")
public class Kart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String modelo;
    private int velocidadMaxima;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pilot_id", referencedColumnName = "id")
    private Pilot piloto;

}