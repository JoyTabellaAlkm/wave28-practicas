package org.nibuitrago.obrasliterarias.service;

import org.nibuitrago.obrasliterarias.models.ObraLiteraria;
import org.nibuitrago.obrasliterarias.repositories.ObraLiterariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraLiterariaService {
    @Autowired
    private ObraLiterariaRepository obraLiterariaRepository;

    public ObraLiteraria guardarObra(ObraLiteraria obra) {
        return obraLiterariaRepository.save(obra);
    }
    public List<ObraLiteraria> obtenerPorAutor(String autor) {
        return obraLiterariaRepository.findByAutor(autor);
    }
}
