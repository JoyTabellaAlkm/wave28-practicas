package com.example.ejerciciolinks.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Link {
    Integer id;
    String link;
    Integer contadorEstadistica;
    String password;

    public void actualizarContador(){
        this.contadorEstadistica+=1;
    }
}
