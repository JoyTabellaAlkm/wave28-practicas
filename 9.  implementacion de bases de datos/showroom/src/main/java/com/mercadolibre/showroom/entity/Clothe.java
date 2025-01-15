package com.mercadolibre.showroom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Clothe {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "CODIGO")
    private String codigo;

    @Column(name = "NOMBRE")
    private String nombre;

    @Column(name = "TIPO")
    private String tipo;

    @Column(name = "MARCA")
    private String marca;

    @Column(name = "COLOR")
    private String color;

    @Column(name = "TALLE")
    private Float talle;

    @Column(name = "CANTIDAD")
    private Integer cantidad;

    @Column(name = "PRECIO_VENTA")
    private Float precioVenta;

}
