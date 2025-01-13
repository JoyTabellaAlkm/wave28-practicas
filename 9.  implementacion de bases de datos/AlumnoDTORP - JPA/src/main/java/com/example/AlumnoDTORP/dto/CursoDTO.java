package com.example.AlumnoDTORP.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CursoDTO {

    private Integer codigo;
    private String nombre;
    private String grado;
    private Boolean certificado;
    private Double duracion;

}
