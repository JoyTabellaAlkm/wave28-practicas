package com.bootcamp.ejercicioblog.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EntradaBlog {
    private Long id;
    private String titulo;
    private String autor;
    private String fechaPublicacion;
}
