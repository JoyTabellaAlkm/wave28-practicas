package com.meli.ejercicio_diploma.model;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class StudentDTO {

    Long id;

    @NotBlank(message = "El nombre del estudiante no puede estar vacio.")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El " +
            "nombre del estudiante debe comenzar con mayuscula.")
    @Size(max = 50, message = "La longitud del nombre del estudiante no puede superar los 50 caracteres.")
    String studentName;

    String message;
    Double averageScore;

    @NotEmpty(message = "La lista de materias no puede estar vacia.")
    List<@Valid SubjectDTO> subjects;

    public StudentDTO(Long id, String studentName, List<@Valid SubjectDTO> subjects) {
        this.id = id;
        this.studentName = studentName;
        this.subjects = subjects;
    }
}
