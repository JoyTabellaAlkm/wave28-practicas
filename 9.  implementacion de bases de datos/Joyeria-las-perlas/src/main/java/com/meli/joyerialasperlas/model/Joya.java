package com.meli.joyerialasperlas.model;

import jakarta.persistence.*;

@Entity
@Table(name = "joya")
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nro_identificatorio")
    private Long id;

    private String nombre;

    private String material;

    private Double peso;

    @Column(name = "posee_piedra")
    private Boolean poseePiedra;

    private Boolean ventaONo;
}
