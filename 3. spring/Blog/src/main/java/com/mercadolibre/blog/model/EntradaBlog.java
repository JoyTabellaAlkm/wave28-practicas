package com.mercadolibre.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlog {
    private Long id;
    private String tituloBlog;
    private String nombreAutor;
    private String fechaPublicacion;
}
