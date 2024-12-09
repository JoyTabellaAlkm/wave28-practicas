package com.dario.dominguez.practicaentradablog.dto;

import lombok.Data;

import java.util.Date;

@Data
public class EntradaBlogDto {
    private Long id;
    private String titulo;
    private String nombreAutor;
    private String fechaPublicacion;
}
