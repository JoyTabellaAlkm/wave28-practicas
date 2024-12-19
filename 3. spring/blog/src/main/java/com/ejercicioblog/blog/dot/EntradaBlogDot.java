package com.ejercicioblog.blog.dot;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntradaBlogDot {
    private int id;
    private String titulo;
    private String nombre;
    private LocalDate fechaPublicacion;
}
