package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO {
    @NotBlank(message = "El nombre del alumno no puede estar vacio")
    @Size(min = 1, max= 100, message = "El nombre debe tener entre 1 y 100 caracteres")
    String studentName;

    @Size(min = 1, max= 100, message = "El mensaje debe tener entre 1 y 100 caracteres")
    String message;

    Double averageScore;

    @NotEmpty(message = "La lista de materias no puede estar vacia")
    @Valid
    List<SubjectDTO> subjects;
}
