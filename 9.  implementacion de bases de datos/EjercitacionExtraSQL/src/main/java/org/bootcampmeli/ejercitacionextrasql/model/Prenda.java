package org.bootcampmeli.ejercitacionextrasql.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "Prenda")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Prenda {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    private String nombre;

    private String tipo;

    private String marca;

    private String talle;

    private String color;

    @Column(name = "cantidad_ventas")
    private Integer cantidadVentas;

    private Double precio;

    @ManyToMany(mappedBy = "prendas")
    private List<Venta> ventas;
}
