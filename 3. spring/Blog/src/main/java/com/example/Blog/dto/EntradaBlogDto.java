package com.example.Blog.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlogDto {
    private Long id;
    private String titulo;
    private String autor;
    private LocalDate date;
}
