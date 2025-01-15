package com.mercadolibre.obraliteraria.service;

import com.mercadolibre.obraliteraria.model.ObraLiteraria;

import java.util.List;

public interface IObraLiterariaService {
    List<ObraLiteraria> getObrasByAutor(String autor);

    List<ObraLiteraria> getObrasByNombre(String keyword);

    List<ObraLiteraria> getObrasByCantidadPaginas();

    List<ObraLiteraria> getObrasByPublicacion(int year);

    List<ObraLiteraria> getObrasByEditorial(String editorial);
}
