package com.mercadolibre.ejerciciodeportistas.services;

import com.mercadolibre.ejerciciodeportistas.request.DeportesDTO;
import com.mercadolibre.ejerciciodeportistas.response.DeportesDTOResponse;

import java.util.List;

public interface IDeportes {
    DeportesDTOResponse crearDeporte(DeportesDTO deporte);
    List<DeportesDTOResponse> devolverDeportes();
    DeportesDTOResponse devolverDeporte(String deporte);
}
