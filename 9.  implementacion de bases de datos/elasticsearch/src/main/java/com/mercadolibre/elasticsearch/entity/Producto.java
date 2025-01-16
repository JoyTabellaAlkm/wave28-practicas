package com.mercadolibre.elasticsearch.entity;

import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.WriteTypeHint;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "producto", createIndex = true, writeTypeHint = WriteTypeHint.FALSE)
public class Producto {

    @Id
    @ReadOnlyProperty
    private String id;

    @Field(type = FieldType.Text)
    private String nombre;

    @Field(type = FieldType.Text)
    private String tipo;

    @Field(name = "precio_venta")
    @JsonProperty("precio_venta")
    private double precioVenta;
    
    @Field(name = "precio_costo")
    @JsonProperty("precio_costo")
    private String precioCosto;
    
    @Field(name = "cantidad_disponible")
    @JsonProperty("cantidad_disponible")
    private String cantidadDisponible;

}
