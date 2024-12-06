package com.mercadolibre.ejerciciodeportistas.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDTOResponse {
    String nombre;
    String apellido;
    String deporte;
}
