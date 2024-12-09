package com.mercadoLibre.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Blog {
    private long id;
    private String titulo;
    private String autor;
    private String fecha;
}
