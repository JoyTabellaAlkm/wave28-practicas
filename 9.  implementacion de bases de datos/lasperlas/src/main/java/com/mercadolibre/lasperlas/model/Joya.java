package com.mercadolibre.lasperlas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Joya {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "nro_identificatorio")
    private long nroIdentificatorio;

    @Column
    private String nombre;

    @Column
    private String material;

    @Column
    private double peso;

    @Column
    private String particularidad;

    @Column(name = "posee_piedra")
    private boolean poseePiedra;

    @Column(name = "venta_o_no")
    private boolean ventaONo;

}
