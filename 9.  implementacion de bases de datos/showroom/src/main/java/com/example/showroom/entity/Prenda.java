package com.example.showroom.entity;

import jakarta.persistence.*;
import lombok.*;

@Data @Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Prenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long codigo;
    String nombre;
    String tipo;
    String marca;
    String color;
    String talle;
    Integer cantidad;
    Double precioVenta;

}
