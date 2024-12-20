package com.meli.obtenerdiploma.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SubjectDTO {

    @NotNull(message = "El nombre del alumno no puede estar vacio")
    String name;

    @NotNull(message = "El puntaje del alumno no puede estar vacio")
    @Min(value = 1, message = "La nota debe ser minimo 1")
    @Max(value = 10, message = "La nota debe ser maximo 10")
    Double score;
}
