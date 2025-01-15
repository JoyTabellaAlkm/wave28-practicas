package com.demo.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

@Data
@Entity
@Table(name = "prendas")
public class Prenda {
    @Id
    @GeneratedValue()
    @UuidGenerator
    private String codigo;
    @Column(name = "nombre", nullable = false)
    private String nombre;
    @Column(name = "tipo", nullable = false)
    private String tipo;
    @Column(name = "marca", nullable = false)
    private String marca;
    @Column(name = "color", nullable = false)
    private String color;
    @Column(name = "talle", nullable = false)
    private Integer talle;
    @Column(name = "cantidad", nullable = false)
    private Integer cantidad;
    @Column(name = "precio_venta", nullable = false)
    private Double precioVenta;
}
