package com.bootcamp.ejercicio_links.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Links {
    private Long Id;
    private Integer contador;
    private String password;
    private String linkUrl;
    private String shortUrl;

    public void incrementarContador(){
        contador++;
    }
}
