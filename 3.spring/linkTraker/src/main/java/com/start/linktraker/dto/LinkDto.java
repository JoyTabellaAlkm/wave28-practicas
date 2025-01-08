package com.start.linktraker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LinkDto {
    Integer id;
    String nombre;
    String url;
    int cantidadDeBusquedas;
}
