package com.bootcamp.ejerciciocovid19.dto;


import lombok.*;

@ToString
@AllArgsConstructor
@Setter
@Getter
public class SintomaDto {
    public String nombre;
    public int nivelDeGravedad;
}
