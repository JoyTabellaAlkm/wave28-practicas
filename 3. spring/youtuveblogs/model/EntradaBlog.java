package com.mercadolibre.youtuveblogs.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EntradaBlog {
    private String idBlog;
    private String titulo;
    private String nombreAutor;
    private String fechaPublicacion;
}
