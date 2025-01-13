package com.mercadolibre.las_perlas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "JOYA")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Joya {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "MATERIAL")
    private String material;

    @Column(name = "PESO")
    private Long peso;

    @Column(name = "PARTICULARIDAD")
    private String particularidad;

    @Column(name = "POSEE_PIEDRA")
    private Boolean poseePiedra;

    @Column(name = "VENTA_O_NO")
    private Boolean ventaONo;
}
