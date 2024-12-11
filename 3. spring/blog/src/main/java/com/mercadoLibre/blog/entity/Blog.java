package com.mercadoLibre.blog.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.concurrent.atomic.AtomicLong;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Blog {
    private long id;
    private String titulo;
    private String autor;
    private String fecha;
}
