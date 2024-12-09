package com.mercadolibre.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogDTO {
    private int id;
    private String titulo;
    private String nombreAutor;
    private String fechaPublicacion;
}