package com.bootcamp.obrasLiterarias.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.time.LocalDate;

@Document(indexName = "obras")
@Getter @Setter
public class ObraLiteraria {
    @Id
    private Long id;
    private String nombre;
    private String autor;
    private int cantidadDePaginas;
    private String editorial;
    private LocalDate anioDePublicacion;
}
