package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.Singular;
import org.jetbrains.annotations.NotNull;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @Size(max = 50, message = "La longitud del nombre no puede superar los 50 caracteres")
    @NotBlank(message = "El nombre del alumno no puede estar vacío.")

    @Pattern(regexp = "^[A-Z].*", message = "El nombre del alumno debe comenzar con mayúscula")    String studentName;
    String message;
    Double averageScore;
    @NotEmpty(message = "El alumno debe tener al menos una materia cargada")
    List<@Valid SubjectDTO> subjects;
}
