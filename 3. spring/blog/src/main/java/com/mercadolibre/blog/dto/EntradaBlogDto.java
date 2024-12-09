package com.mercadolibre.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntradaBlogDto {
    private Long id;
    private String titulo;
    private String nombreAutor;
    private String fechaPublicacion;
}
