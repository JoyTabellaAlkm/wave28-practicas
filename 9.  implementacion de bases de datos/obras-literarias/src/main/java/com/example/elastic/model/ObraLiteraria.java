package com.example.elastic.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@Document(indexName = "libros")
public class ObraLiteraria {
    @Id
    private Long id;
    private String nombre;
    private String autor;
    private Integer cantidadPaginas;
    private String editorial;
    private int primeraPublicacion;
}
