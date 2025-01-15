package com.bootcamp.ejercicio_obras.service;

import com.bootcamp.ejercicio_obras.model.ObraLiteraria;
import com.bootcamp.ejercicio_obras.repository.ObraLiterariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ObraLiterariaService {

    @Autowired
    private ObraLiterariaRepository repository;

    public ObraLiteraria save(ObraLiteraria obra) {
        return repository.save(obra);
    }

    public List<ObraLiteraria> findByAutor(String autor) {
        return repository.findByAutor(autor);
    }

    public List<ObraLiteraria> findByNombreContaining(String palabraClave) {
        return repository.findByNombreContaining(palabraClave);
    }


    public List<ObraLiteraria> findByAnioPrimeraPublicacionLessThan(int anio) {
        return repository.findByAnioPrimeraPublicacionLessThan(anio);
    }

    public List<ObraLiteraria> findByEditorial(String editorial) {
        return repository.findByEditorial(editorial);
    }
    public List<ObraLiteraria> findTop5ByOrderByCantidadPaginasDesc() {
        return repository.findAll(PageRequest.of(0, 5)).getContent();
    }
}
