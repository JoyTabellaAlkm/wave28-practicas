package com.bootcamp.linktracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseMetricas {
    private Long id;
    private String link;
    private int cantidadRedirecciones;
}
