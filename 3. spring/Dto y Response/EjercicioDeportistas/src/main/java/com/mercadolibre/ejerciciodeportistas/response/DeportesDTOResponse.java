package com.mercadolibre.ejerciciodeportistas.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DeportesDTOResponse {
    String nombre;
    String nivel;
}
