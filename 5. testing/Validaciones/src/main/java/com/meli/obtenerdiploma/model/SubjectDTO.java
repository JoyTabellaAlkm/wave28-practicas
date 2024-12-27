package com.meli.obtenerdiploma.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.*;

@Getter @Setter
@Data
@AllArgsConstructor
public class SubjectDTO {
   @NotBlank(message = "El nombre del estudiante no puede estar vacío.")
   @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre de la materia debe comenzar con mayúscula.")
   @Size(max = 30, message = "La longitud del nombre no puede superar los 30 caracteres.")
   String name;

   @Max(value = 10, message = "La calificación no puede superar los 10.")
   @Min(value = 0, message = "La calificación no puede ser menor a 0.")
   Double score;
}
