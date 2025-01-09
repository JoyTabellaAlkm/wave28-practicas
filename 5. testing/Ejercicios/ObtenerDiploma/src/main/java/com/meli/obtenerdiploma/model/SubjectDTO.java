package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
public class SubjectDTO {
    @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres")
    @NotBlank(message = "El nombre de la materia no puede estar vacío.")
    @Pattern(regexp = "^[A-Z].*", message = "El nombre de la materia debe comenzar con mayúscula")
    String name;
    @Max(value = 10, message = "La nota no puede ser mayor a 10")
            @Min(value = 0, message = "La nota no puede ser menor a 0")
            @NotNull(message = "La nota no puede estar vacía")
    Double score;
}
