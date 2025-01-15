package com.mercadolibre.showroom.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClotheDTO {

    private Long id;
    private String codigo;
    private String nombre;
    private String tipo;
    private String marca;
    private String color;
    private Float talle;
    private Integer cantidad;
    private Float precioVenta;
}
