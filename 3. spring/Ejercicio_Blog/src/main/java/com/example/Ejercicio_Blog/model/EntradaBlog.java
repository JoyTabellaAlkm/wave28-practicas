package com.example.Ejercicio_Blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EntradaBlog  {
    private int id;
    private String titulo;
    private String autor;
    private String fechaPublicacion;

}
