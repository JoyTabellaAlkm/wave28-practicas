package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
@Valid
public class StudentDTO {
    @NotBlank(message="El estudiante no puede estar en blanco")
    @Size(max = 50, message = "El estudiante debe ser menor a 50 caracteres")
    @Pattern(regexp = "^[A-Z][a-z]*$")
    String studentName;
    String message;
    Double averageScore;
    @NotEmpty(message = "La lista no puede estar vacia")
    List<SubjectDTO> subjects;
}
