package com.mercadolibre.showroom.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@Entity
@Table(name = "prendas")
public class Prenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String nombre;
    private String tipo;
    private String marca;
    private String color;
    private String talle;
    private Integer cantidad;
    @Column(name = "precio_compra")
    @JsonProperty("precio_compra")
    private Double precioVenta;

    @ManyToMany(mappedBy = "prendas", cascade = CascadeType.PERSIST)
    @JsonIgnore
    private List<Venta> ventas;
}
