package com.example.youtubeblog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EntradaBlogDto {
    private String idBlog;
    private String titulo;
    private String nombreAutor;
    private String fechaPublicacion;
}
