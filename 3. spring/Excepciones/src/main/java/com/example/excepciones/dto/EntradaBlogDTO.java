package com.example.excepciones.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EntradaBlogDTO {

    Long id;
    String titulo;
    String nombreAutor;
    Date fechaPublicacion;
}