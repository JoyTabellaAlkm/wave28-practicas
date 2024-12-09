package com.blog.spring.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EntradaBlogDTO {

    private int id;
    private String nombre;
    private String titulo;
    private LocalDate fecha;

}
