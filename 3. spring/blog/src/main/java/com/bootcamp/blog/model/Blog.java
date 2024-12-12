package com.bootcamp.blog.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Blog {
    private int id;
    private String titulo;
    private String autor;
    private String fechaPublicacion;
}
