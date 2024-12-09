package com.mercadolibre.Blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BlogDTO {
    private int id;
    private String titulo;
    private String nombre;
    private LocalDate fechaPublicacion;
}
