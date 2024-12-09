package com.example.blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BlogDtoResponse {

    private String titulo;
    private String autor;
    private String fechaPublicacion;
}
