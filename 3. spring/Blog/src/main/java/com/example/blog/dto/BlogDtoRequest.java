package com.example.blog.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDtoRequest {

    private Integer id;
    private String titulo;
    private String autor;
    private String fechaPublicacion;
}
