package com.bootcamp.relaciones.service;

import com.bootcamp.relaciones.dto.LibroDto;
import com.bootcamp.relaciones.entity.Autor;
import com.bootcamp.relaciones.entity.Editorial;
import com.bootcamp.relaciones.entity.Libro;
import com.bootcamp.relaciones.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LibroServiceImpl implements LibroService {

    @Autowired
    LibroRepository libroRepository;

    @Override
    public void creaTodo(LibroDto libroDto) {
        Libro l = new Libro();
        l.setNombre(libroDto.getNombre());
        l.setIsbn(libroDto.getIsbn());
        Editorial e = new Editorial();
        e.setNombre(libroDto.getEditorial().getNombre());
        l.setAutores(libroDto.getAutores().stream().map(dto -> new Autor(dto.getNombre(), dto.getApellido())).toList());
        l.setEditorial(e);
        libroRepository.save(l);
    }
}
