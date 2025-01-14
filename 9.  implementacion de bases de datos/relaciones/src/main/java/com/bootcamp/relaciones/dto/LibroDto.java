package com.bootcamp.relaciones.dto;

import com.bootcamp.relaciones.entity.Autor;
import com.bootcamp.relaciones.entity.Editorial;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
public class LibroDto {
    private String nombre;
    private String isbn;
    private List<AutorDto> autores;
    private EditorialDto editorial;
}
