package com.bootcamp.ejercicio_blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlog {
    private String idBlog;
    private String titulo;
    private String nombreAutor;
    private String fechaPublicacion;
}
