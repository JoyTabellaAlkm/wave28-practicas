package com.mercadolibre.joyeria_las_perlas.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "joya")
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String nombre;
    private String material;
    private Double peso;
    private String particularidad;
    @Column(name = "posee_piedra")
    private boolean poseePiedra;
    private boolean venta;
}
