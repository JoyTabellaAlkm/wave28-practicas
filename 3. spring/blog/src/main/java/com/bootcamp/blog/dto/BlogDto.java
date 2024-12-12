package com.bootcamp.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BlogDto {
    private int id;
    private String titulo;
    private String autor;
    private String fechaPublicacion;
}
