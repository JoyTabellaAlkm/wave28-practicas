package com.mercadolibre.elasticsearch.entity;

import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.WriteTypeHint;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "empleados", createIndex = true, writeTypeHint = WriteTypeHint.FALSE)
public class Empleado {

    @Id
    @ReadOnlyProperty
    private String id;

    @Field(type = FieldType.Text)
    private String nombre;

    @Field(type = FieldType.Text)
    private String apellido;

    @Field
    private short edad;

    @Field(type = FieldType.Text)
    private String ciudad;

    @Field(type = FieldType.Text)
    private String departamento;

}
