package com.example.excepciones.modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EntradaBlog {
    
    Long id;
    String titulo;
    String nombreAutor;
    Date fechaPublicacion;
}
