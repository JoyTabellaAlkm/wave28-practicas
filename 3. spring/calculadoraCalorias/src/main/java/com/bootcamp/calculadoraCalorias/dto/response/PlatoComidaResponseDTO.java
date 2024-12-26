package com.bootcamp.calculadoraCalorias.dto.response;

import com.bootcamp.calculadoraCalorias.dto.request.IngredienteDTO;

import java.util.List;

public class PlatoComidaResponseDTO {
    private String nombre;
    private double caloriasTotales;
    private List<IngredienteDTO> ingredientes;
    private IngredienteDTO ingredienteDTO;
}
