package com.meli.deportista.services;

import com.meli.deportista.dto.DeporteDto;
import com.meli.deportista.dto.responses.DeportesYPersonasResponse;

import java.util.List;

public interface IDeporte {

    public List<DeporteDto> listaDeportes();
    public DeporteDto encontrarDeporte(String nombre);
    public List<DeportesYPersonasResponse> encontrarDeportesPersonas();

}