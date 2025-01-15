package org.bootcampmeli.ejercitacionextrasql.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PrendaDto {

    private Long codigo;

    private String nombre;

    private String tipo;

    private String marca;

    private String talle;

    private String color;

    private Integer cantidadVentas;

    private Double precio;
}
