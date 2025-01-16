package com.example.empleadoselasticsearch.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "empleados")
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {
    @Id
    private String id;
    private String nombre;
}
