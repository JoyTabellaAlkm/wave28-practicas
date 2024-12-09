package com.blog.spring.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EntradaBlog {
    private int id;
    private String nombre;
    private String titulo;
    private LocalDate fecha;

}
