package org.ejercicios.lasperlas.model;

import jakarta.persistence.*;
import lombok.*;

import javax.naming.Name;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "joyas")
@Data
public class Joya {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String material;

    @Column(name = "peso_gramos")
    private double pesoGramos;
    private String particularidad;

    @Column(name = "posee_piedra")
    private boolean poseePiedra;

    @Column(name = "venta_o_no")
    private boolean ventaONo;


}
