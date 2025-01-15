package com.example.empleados.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter
@Setter
@Document( indexName = "empleados")
public class Empleado {

    @Id
    private String id;

    private String nombre;

    private String apellido;

    private int edad;

    private String ciudad;

    private String departamento;
}
