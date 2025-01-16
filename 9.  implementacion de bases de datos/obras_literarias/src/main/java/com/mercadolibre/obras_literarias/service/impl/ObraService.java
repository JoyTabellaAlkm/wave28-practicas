package com.mercadolibre.obras_literarias.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.mercadolibre.obras_literarias.dto.CreateObraDto;
import com.mercadolibre.obras_literarias.entity.Obra;
import com.mercadolibre.obras_literarias.repository.IObraRepository;
import com.mercadolibre.obras_literarias.service.IObraService;

@Service
public class ObraService implements IObraService {

    @Autowired
    private IObraRepository obraRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public Obra save(CreateObraDto obra) {
        return obraRepository.save(modelMapper.map(obra, Obra.class));
    }

    @Override
    public Iterable<Obra> findAll() {
        return obraRepository.findAll();
    }

    @Override
    public Iterable<Obra> findAllByAutor(String autor) {
        return obraRepository.findAllByAutor(autor);
    }

    @Override
    public Iterable<Obra> findAllByNombreLike(String query) {
        return obraRepository.findAllByNombreLike(query);
    }

    @Override
    public Iterable<Obra> findTop5MostCantidadPaginas() {
        Sort sort = Sort.by(Sort.Direction.DESC, "cantidadPaginas");
        Pageable pageable = PageRequest.of(0, 5, sort);
        return obraRepository.findTop5MostCantidadPaginas(pageable);
    }

    @Override
    public Iterable<Obra> findAllByAnioPublicacionDown(int anioPublicacion) {
        return obraRepository.findAllByAnioPublicacionDown(anioPublicacion);
    }

    @Override
    public Iterable<Obra> findAllByEditorial(String editorial) {
        return obraRepository.findAllByEditorial(editorial);
    }

}
