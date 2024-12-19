package com.ejercicioblog.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlogEntity {
    private int id;
    private String titulo;
    private String nombre;
    private LocalDate fechaPublicacion;
}
