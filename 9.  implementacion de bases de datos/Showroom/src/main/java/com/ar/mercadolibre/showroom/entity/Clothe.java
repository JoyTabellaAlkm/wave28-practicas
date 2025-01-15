package com.ar.mercadolibre.showroom.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "clothes")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Clothe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nombre;
    private String tipo;
    private String marca;
    private String color;
    private String talla;
    private int cantidad;
    @Column(name = "precio_venta")
    private double precioVenta;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sale_numero", nullable = true)
    private Sale sale;
}







