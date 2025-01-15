package com.mercadolibre.obraliteraria.service.impl;

import com.mercadolibre.obraliteraria.model.ObraLiteraria;
import com.mercadolibre.obraliteraria.repository.IObraLiterariaRepository;
import com.mercadolibre.obraliteraria.service.IObraLiterariaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraLiterariaService implements IObraLiterariaService {
    private final IObraLiterariaRepository obraLiterariaRepository;

    public ObraLiterariaService(IObraLiterariaRepository obraLiterariaRepository) {
        this.obraLiterariaRepository = obraLiterariaRepository;
    }

    public List<ObraLiteraria> getObrasByAutor(String autor){
        return obraLiterariaRepository.findObraLiterariaByAutor(autor);
    }

    public List<ObraLiteraria> getObrasByNombre(String keyword){
        return obraLiterariaRepository.findObraLiterariaByNombreContainingIgnoreCase(keyword);
    }

    public List<ObraLiteraria> getObrasByCantidadPaginas(){
        return obraLiterariaRepository.findTop5ByOrderByCantidadPaginasDesc();
    }

    public List<ObraLiteraria> getObrasByPublicacion(int year){
        return obraLiterariaRepository.findObraLiterariaByPrimeraPublicacionBefore(year);
    }

    public List<ObraLiteraria> getObrasByEditorial(String editorial){
        return obraLiterariaRepository.findObraLiterariaByEditorial(editorial);
    }


}
