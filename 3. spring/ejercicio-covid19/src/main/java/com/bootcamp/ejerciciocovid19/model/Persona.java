package com.bootcamp.ejerciciocovid19.model;

import lombok.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@ToString
public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
}
