package com.example.Ejercicio_Blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class EntradaBlogDto implements Serializable {
    private int id;
    private String titulo;
    private String autor;
    private String fechaPublicacion;
}
