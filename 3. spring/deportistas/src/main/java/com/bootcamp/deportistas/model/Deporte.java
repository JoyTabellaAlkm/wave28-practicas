package com.bootcamp.deportistas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Deporte {
    private Long id;
    private String nombre;
    private int nivel;

}
