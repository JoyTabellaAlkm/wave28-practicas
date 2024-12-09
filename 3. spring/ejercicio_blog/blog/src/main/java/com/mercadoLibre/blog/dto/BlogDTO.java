package com.mercadoLibre.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BlogDTO {
    private long id;
    private String titulo;
    private String autor;
    private String fecha;
}
