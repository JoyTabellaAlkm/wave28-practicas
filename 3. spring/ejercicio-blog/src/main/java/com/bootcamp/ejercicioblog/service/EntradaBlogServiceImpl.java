package com.bootcamp.ejercicioblog.service;

import com.bootcamp.ejercicioblog.exception.EntradaBlogNoExisteException;
import com.bootcamp.ejercicioblog.exception.EntradaBlogYaExisteException;
import com.bootcamp.ejercicioblog.model.EntradaBlog;
import com.bootcamp.ejercicioblog.repository.IEntradaBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EntradaBlogServiceImpl implements IEntradaBlogService{
    @Autowired
    IEntradaBlogRepository entradaBlogRepository;

    @Override
    public Long crearEntradaBlog(EntradaBlog entradaBlog) {
        if (existeEntradaConId(entradaBlog.getId())) {
            throw new EntradaBlogYaExisteException("El id proporcionado ya existe, ingrese otro");
        }
         return entradaBlogRepository.crearEntradaBlog(entradaBlog);
    }

    @Override
    public EntradaBlog obtenerEntradaPorId(Long id) {
        List<EntradaBlog> entradas = entradaBlogRepository.obtenerEntradas();

        Optional<EntradaBlog> entradaEncontrada = entradas.stream().filter(e -> e.getId().equals(id)).findFirst();
        if(entradaEncontrada.isEmpty()) {
            throw new EntradaBlogNoExisteException("El id proporcionado no corresponde a ninguna entrada del blog");
        }

        return entradaEncontrada.get();
    }

    @Override
    public List<EntradaBlog> obtenerEntradas() {
        return entradaBlogRepository.obtenerEntradas();
    }

    private boolean existeEntradaConId(Long id) {
        return entradaBlogRepository.obtenerEntradas().stream().anyMatch(e -> e.getId().equals(id));
    }
}
