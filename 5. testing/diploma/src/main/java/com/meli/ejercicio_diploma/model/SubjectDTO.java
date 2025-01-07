package com.meli.ejercicio_diploma.model;

import lombok.*;

import javax.validation.constraints.*;
import java.io.Serializable;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class SubjectDTO implements Serializable {
    @NotBlank(message = "El nombre de la materia no puede estar vacio.")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El " +
            "nombre de la materia debe comenzar con mayuscula.")
    @Size(max = 30, message = "La longitud del nombre de la materia no puede superar los 30 caracteres.")
    String name;

    @NotNull(message = "La nota de la materia no puede estar vacia.")
    @DecimalMax(value = "10.0", message = "La nota maxima de la materia es de 10 pts.")
    @DecimalMin(value = "0.0", message = "La nota minima de la materia es de 0 pts.")
    Double score;
}
