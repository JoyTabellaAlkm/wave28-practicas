package com.mercadolibre.obras_literarias.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateObraDto {

    private String nombre;
    private String autor;

    @JsonProperty("cantidad_paginas")
    private int cantidadPaginas;

    private String editorial;

    @JsonProperty("anio_publicacion")
    private int anioPublicacion;

}
