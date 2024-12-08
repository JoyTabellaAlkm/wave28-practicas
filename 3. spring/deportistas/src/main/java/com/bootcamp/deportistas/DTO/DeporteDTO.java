package com.bootcamp.deportistas.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DeporteDTO {
    private String nombre;
    private int nivel;
}
