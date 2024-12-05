package com.bootcamp.deportistas.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Deporte {
    private Long id;
    private String nombre;
    private String nivel;
}
