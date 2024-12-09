package com.bootcamp.ejercicioblog.service;

import com.bootcamp.ejercicioblog.model.EntradaBlog;
import com.bootcamp.ejercicioblog.repository.IEntradaBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EntradaBlogServiceImpl implements IEntradaBlogService{
    @Autowired
    IEntradaBlogRepository entradaBlogRepository;

    @Override
    public Long crearEntradaBlog(EntradaBlog entradaBlog) {
        return entradaBlogRepository.crearEntradaBlog(entradaBlog);
    }

    @Override
    public EntradaBlog obtenerEntradaPorId(Long id) {
        return entradaBlogRepository.obtenerEntradaPorId(id);
    }

    @Override
    public List<EntradaBlog> obtenerEntradas() {
        return entradaBlogRepository.obtenerEntradas();
    }
}
