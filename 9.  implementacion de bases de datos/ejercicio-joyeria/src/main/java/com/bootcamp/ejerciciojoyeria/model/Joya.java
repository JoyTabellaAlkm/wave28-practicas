package com.bootcamp.ejerciciojoyeria.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "joyas")
@Data
public class Joya {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    private String nombre;

    private String material;

    private double peso;

    private String particularidad;

    @Column(name = "posee_piedra")
    private boolean poseePiedra;

    @Column(name = "venta_o_no")
    private boolean ventaONo;
}
