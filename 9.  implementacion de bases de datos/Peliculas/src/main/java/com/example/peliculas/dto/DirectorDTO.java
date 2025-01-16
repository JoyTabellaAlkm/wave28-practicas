package com.example.peliculas.dto;

import com.example.peliculas.entity.Pelicula;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DirectorDTO {

    private String nombre;
    private List<PeliculaDTO> peliculas;
}
