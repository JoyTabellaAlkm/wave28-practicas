package com.bootcamp.youtuber.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class EntradaBlogDto {
    private Long id;
    private String titulo;
    private String autor;
    private String fechaPublicacion;
}
