package com.bootcamp.ejercicio_blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlogDto {
    private String idBlog;
    private String titulo;
    private String nombreAutor;
    private String fechaPublicacion;
}
