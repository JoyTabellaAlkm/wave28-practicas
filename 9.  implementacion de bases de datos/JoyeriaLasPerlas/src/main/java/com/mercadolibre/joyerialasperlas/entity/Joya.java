package com.mercadolibre.joyerialasperlas.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
@Table(name = "joya")
public class Joya {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long nro_identificatorio;
    private String nombre;
    private String material; //(oro, plata, etc)
    private double peso;  //(en gramos)
    private String particularidad;
    private boolean posee_piedra;
    private boolean ventaONo;
}
