package com.meli.obtenerdiploma.model;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter @Setter
public class SubjectDTO {
    @NotBlank(message = "El nombre de la materia no puede estar vacía")
    String name;
    @Min(value = 1, message = "La nota de la materia debe ser mayor o igual a 1")
    Double score;
}
