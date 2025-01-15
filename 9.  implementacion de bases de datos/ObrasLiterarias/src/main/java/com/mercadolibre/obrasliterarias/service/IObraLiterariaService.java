package com.mercadolibre.obrasliterarias.service;

import com.mercadolibre.obrasliterarias.model.ObraLiteraria;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IObraLiterariaService {
    List<ObraLiteraria> getObrasByAutor(String autor);
    List<ObraLiteraria> getObrasByTituloKeyword(String tituloKeyword);
    List<ObraLiteraria> getObrasBeforeAnio(int anio);
    List<ObraLiteraria> getObrasByEditorial(String editorial);
    List<ObraLiteraria> getTop5ObrasByCantidadPaginas();

}
