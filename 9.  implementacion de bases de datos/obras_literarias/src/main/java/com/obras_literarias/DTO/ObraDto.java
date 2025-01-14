package com.obras_literarias.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObraDto {
    private String id;
    private String name;
    private String autor;

    private int cantidadDePaginas;

    private String editorial;
    private int anoDePublicacion;
}
