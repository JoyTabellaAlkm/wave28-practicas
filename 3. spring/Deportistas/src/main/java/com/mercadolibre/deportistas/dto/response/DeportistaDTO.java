package com.mercadolibre.deportistas.dto.response;

import lombok.Data;

@Data
public class DeportistaDTO {
    private String nombreCompleto;
    private DeporteNombreDTO nombreDeporte;
}
