package com.elasticsearch.obrasliterarias;

import com.elasticsearch.obrasliterarias.model.ObraLiteraria;
import com.elasticsearch.obrasliterarias.repository.ObraLiterariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraLiterariaService {

    @Autowired
    ObraLiterariaRepository obraLiterariaRepo;

    public List<ObraLiteraria> findByAutor(String autor) {
        return obraLiterariaRepo.findAllByAutor(autor);
    }

    public List<ObraLiteraria> findByName(String nombre) {
        return obraLiterariaRepo.findAllByNombreContaining(nombre);
    }

    public List<ObraLiteraria> getTop5CantPaginas() {
        return obraLiterariaRepo.findTop5ByOrderByCantPaginasDesc();
    }

    public List<ObraLiteraria> getAllBefore(Integer anio) {
        return obraLiterariaRepo.findAllByAnioPublicacionLessThan(anio);
    }

    public List<ObraLiteraria> findByEditorial(String editorial) {
        return obraLiterariaRepo.findAllByEditorialCustom(editorial);
    }
}
