package com.nombres.starwars.service;

import com.nombres.starwars.dto.response.NombreDtoResponse;

import java.util.List;

public interface INombre {
    public List<NombreDtoResponse> obtenerNombre(String query);
}
