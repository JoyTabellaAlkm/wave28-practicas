package com.example.demo.model;

import com.example.demo.service.MascotaServiceImpl;
import lombok.Data;

import java.util.List;

@Data
public class Persona {

    private String nombre;
    private String apellido;
    private Integer edad;
    private List<Mascota> mascotasList;
}
