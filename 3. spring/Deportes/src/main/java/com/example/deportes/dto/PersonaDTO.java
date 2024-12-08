package com.example.deportes.dto;

import com.example.deportes.controller.Deporte;
import lombok.Data;

import java.util.List;

@Data
public class PersonaDTO {

   private String nombre;
   private String apellido;
   private Integer edad;
   private DeporteDTO deporte;

}
