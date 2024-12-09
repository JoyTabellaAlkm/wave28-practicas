package com.demo.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@AllArgsConstructor
@Data
public class EntradaBlog {
    private Integer id;
    private String titulo;
    private String nombre;
    private LocalDate fechaPublicacion;
}
