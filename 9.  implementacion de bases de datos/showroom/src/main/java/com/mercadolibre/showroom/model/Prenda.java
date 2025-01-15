package com.mercadolibre.showroom.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "prendas")
public class Prenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codigo;
    private String nombre;
    private String tipo;
    private String marca;
    private String color;
    private String talle;
    private int cantidad;
    @Column(name = "precio_venta")
    private double precioVenta;
    @ManyToMany(mappedBy = "prendas") // Mapea al atributo "prendas" de la clase Venta
    private List<Venta> ventas;
}
