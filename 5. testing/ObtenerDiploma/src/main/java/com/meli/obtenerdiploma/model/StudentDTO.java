package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotNull(message = "El nombre del alumno no puede estar vacio")
    @Size(min = 1, max= 100, message = "El nombre debe tener entre 1 y 100 caracteres")
    String studentName;

    @Size(min = 1, max= 100, message = "El mensaje debe tener entre 1 y 100 caracteres")
    String message;

    Double averageScore;

    @NotNull(message = "La lista de materias no puede estar vacia")
    List<SubjectDTO> subjects;
}
