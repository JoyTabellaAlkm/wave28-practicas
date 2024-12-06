package com.primer_proyecto_spring.pruebaspring.practicas.dto;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Getter
@Setter
public class PersonaDto {
    private String nombre;
    private String apellido;
    private Integer edad;
}
