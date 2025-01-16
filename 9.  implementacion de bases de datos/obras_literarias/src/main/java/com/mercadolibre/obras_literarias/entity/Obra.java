package com.mercadolibre.obras_literarias.entity;

import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "obras", createIndex = true)
public class Obra {

    @Id
    @ReadOnlyProperty
    private String id;

    private String nombre;
    private String autor;

    @Field(name = "cantidad_paginas")
    @JsonProperty("cantidad_paginas")
    private int cantidadPaginas;

    private String editorial;

    @Field(name = "anio_publicacion")
    @JsonProperty("anio_publicacion")
    private int anioPublicacion;

}
