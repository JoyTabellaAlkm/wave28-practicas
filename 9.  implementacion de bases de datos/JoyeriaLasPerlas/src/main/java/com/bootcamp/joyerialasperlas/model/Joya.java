package com.bootcamp.joyerialasperlas.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nro_identificatorio")
    Long nroIdentificatorio;

    String nombre;

    String material;

    double peso;

    String particularidad;

    @Column(name = "posee_piedra")
    boolean poseePiedra;

    @Column(name = "venta_o_no")
    boolean ventaONo;
}
