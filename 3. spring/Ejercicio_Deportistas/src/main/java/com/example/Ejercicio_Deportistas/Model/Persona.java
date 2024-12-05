package com.example.Ejercicio_Deportistas.Model;

import lombok.*;

/*
@Getter
@Setter
@ToString
@AllArgsConstructor*/


@Data
public class Persona {
    private String nombre;
    private String apellido;
    private int edad;
    private Deporte deporte;

}
