package com.mercadolibre.obrasliterarias.service;

import com.mercadolibre.obrasliterarias.model.ObraLiteraria;
import com.mercadolibre.obrasliterarias.repository.IObraLiterariaRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraLiterariaService implements IObraLiterariaService {

    private final IObraLiterariaRepository obraLiterariaRepository;

    public ObraLiterariaService(IObraLiterariaRepository obraLiterariaRepository) {
        this.obraLiterariaRepository = obraLiterariaRepository;
    }

    @Override
    public List<ObraLiteraria> getObrasByAutor(String autor) {
        Pageable pageable = PageRequest.of(0, 50);
        return obraLiterariaRepository.findByAutor(autor, pageable).stream().toList();
    }

    @Override
    public List<ObraLiteraria> getObrasByTituloKeyword(String tituloKeyword) {
        Pageable pageable = PageRequest.of(0, 50);
        return obraLiterariaRepository.findByTitulo(tituloKeyword, pageable).stream().toList();
    }

    @Override
    public List<ObraLiteraria> getObrasBeforeAnio(int anio) {
        Pageable pageable = PageRequest.of(0, 50);
        return obraLiterariaRepository.findByAnioPrimeraPublicacionBefore(anio, pageable).stream().toList();
    }

    @Override
    public List<ObraLiteraria> getObrasByEditorial(String editorial) {
        Pageable pageable = PageRequest.of(0, 50);
        return obraLiterariaRepository.findByEditorial(editorial, pageable).stream().toList();
    }

    @Override
    public List<ObraLiteraria> getTop5ObrasByCantidadPaginas() {
        Pageable pageable = PageRequest.of(0, 5);
        return obraLiterariaRepository.findTop5ByOrderByCantidadPaginasDesc(pageable).stream().toList();
    }
}
