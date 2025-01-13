package com.lasPerlas.jewerly.model;

import jakarta.persistence.*;
import lombok.Data;

import javax.lang.model.element.Name;

@Data
@Entity
@Table(name = "Jewels")
public class Jewel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nro_Identificatorio")
    private Long nroIdentificatorio;
    private String nombre;
    private String material;
    private double peso;
    private String particularidad;
    @Column(name = "posee_piedra")
    private boolean poseePiedra;
    @Column(name = "venta_o_no")
    private boolean ventaONo;
}
