package com.mercadolibre.ejerciciodeportistas.services;

import com.mercadolibre.ejerciciodeportistas.response.PersonaDTOResponse;

import java.util.List;

public interface IPersonas {
    List<PersonaDTOResponse> devolverPersonas();
}
