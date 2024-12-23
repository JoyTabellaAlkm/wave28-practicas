package com.meli.obtenerdiploma.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
public class StudentDTO {
    @NotEmpty(message = "El campo no puede estar vacío")
    @Size(min = 5, max = 10, message = "El nombre debe ser de entre 5 y 10 caracteres")
    String studentName;
    String message;
    Double averageScore;
    List<@Valid SubjectDTO> subjects;
}
