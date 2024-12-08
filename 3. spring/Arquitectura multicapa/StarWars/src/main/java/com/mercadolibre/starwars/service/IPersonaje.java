package com.mercadolibre.starwars.service;

import com.mercadolibre.starwars.dto.PersonajeDtoResponse;

import java.util.List;

public interface IPersonaje {
    List<PersonajeDtoResponse> devolverPersonaje(String name);
}
