package com.example.showroom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="prendas")
public class Prenda {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long codigo;

    private String nombre;
    private String tipo;
    private String marca;
    private String color;
    private String talla;
    private Integer cantidad;

    @Column(name="precio_venta")
    private Double precioVenta;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "venta_id", nullable = false)
    private Venta venta;

}
