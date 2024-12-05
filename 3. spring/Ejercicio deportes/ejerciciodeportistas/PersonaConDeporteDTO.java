package com.example.ejerciciodeportistas;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonaConDeporteDTO {
    private String nombre;
    private String apellido;
    private String nombreDeporte;
}
