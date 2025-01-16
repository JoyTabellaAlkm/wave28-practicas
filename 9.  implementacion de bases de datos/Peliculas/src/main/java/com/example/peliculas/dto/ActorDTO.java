package com.example.peliculas.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActorDTO {
    private String nombre;
    private List<PeliculaDTO> peliculas;
}
