package com.example.demoUnitTest.dto;

import com.example.demoUnitTest.model.Curso;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlumnoDTO {
    @NotNull(message = "El id es obligatorio")
    @Positive(message = "El valor debe ser POSITIVO")
    private Integer id;

    @Size(min = 3, max = 10, message = "El nombre debe tener al menos 3 caracteres")
    @Pattern(regexp = "([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El nombre del estudiante debe comenzar con mayúscula.")
    private String nombre;

    @Size(min = 3, max = 10, message = "El apellido debe tener al menos 3 caracteres")
    @Pattern(regexp = "([A-Z]|[0-9])[\\s|[0-9]|A-Z|a-z|ñ|ó|í|á|é|ú|Á|Ó|É|Í|Ú]*$", message = "El apellido del estudiante debe comenzar con mayúscula.")
    private String apellidos;

    @NotEmpty(message = "La lista de cursos no puede estar vacía")
    @JsonProperty("cursos_list")
    private List<@Valid CursoDTO> cursosList;

}
