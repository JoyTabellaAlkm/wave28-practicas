package com.example.elastic.service;

import com.example.elastic.model.ObraLiteraria;
import com.example.elastic.repository.IObraLiterariaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraLiterariaService {
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
