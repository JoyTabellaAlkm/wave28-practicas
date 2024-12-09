package com.dario.dominguez.practicaentradablog.entity;

import lombok.Data;

import java.util.Date;

@Data
public class EntradaBlog {
    private Long id;
    private String titulo;
    private String nombreAutor;
    private String fechaPublicacion;
}
