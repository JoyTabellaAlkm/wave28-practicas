package org.showroommysql.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Ropa {

    @Id
    private int codigo;

    private String nombre;
    private String tipo;
    private String marca;
    private String color;
    private String talle;
    private int cantidad;
    private float precio;

    @ManyToMany(mappedBy = "ropa")
    private Set<Venta> ventas = new HashSet<>();
}
