package com.ar.mercadolibre.obrasliterarias.service;

import com.ar.mercadolibre.obrasliterarias.dto.ObraLiterariaDTO;

import java.util.List;

public interface IObraLiterariaService {
    ObraLiterariaDTO create(ObraLiterariaDTO obraLiterariaDTO);
    List<ObraLiterariaDTO> encontrarPorNombre(String nombre);
    List<ObraLiterariaDTO> encontrarTodasLasObras();
    List<ObraLiterariaDTO> encontrarPorAutor(String autor);
    List<ObraLiterariaDTO> encontrarCincoObrasConMasPaginas();
    List<ObraLiterariaDTO> encontrarObrasAntesDeAnio(Integer anio);
    List<ObraLiterariaDTO> encontrarPorEditorial(String editorial);
}
