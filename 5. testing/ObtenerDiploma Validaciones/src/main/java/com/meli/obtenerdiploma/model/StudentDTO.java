package com.meli.obtenerdiploma.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentDTO {
    public StudentDTO(String studentName, List<SubjectDTO> subjects) {
        this.studentName = studentName;
        this.subjects = subjects;
    }

    @NotBlank(message = "El nombre del estudiante no puede estar vacío.")
    @Pattern(regexp="([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre del estudiante debe comenzar con mayúscula.")
    @Size(max = 50, message = "La longitud del nombre del estudiante no puede superar los 50 caracteres.")
    String studentName;


    String message;
    Double averageScore;

    @NotEmpty(message = "La lista de materias no puede estar vacía.")
    @Valid
    List<SubjectDTO> subjects;


}
