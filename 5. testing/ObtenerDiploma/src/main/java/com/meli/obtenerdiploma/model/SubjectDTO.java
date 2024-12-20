package com.meli.obtenerdiploma.model;

import com.meli.obtenerdiploma.validation.StartsWithUpperCase;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class SubjectDTO {
    @NotEmpty(message = "El nombre de la materia no puede estar vacío")
    @StartsWithUpperCase(message = "El nombre de la materia debe comenzar con mayúscula")
    @Max(value=50, message="La longitud del nombre no puede superar los 30 caracteres")
    String name;
    @NotEmpty(message = "La nota no puede estar vacía")
    @Min(value = 0, message = "La mínima nota es 0.0")
    @Max(value = 10, message = "La máxima nota es 10.0")
    Double score;
}
