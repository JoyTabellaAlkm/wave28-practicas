package com.bootcamp.obras_literarias.service;

import com.bootcamp.obras_literarias.model.Libro;
import com.bootcamp.obras_literarias.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibroService {

    private LibroRepository libroRepository;

    @Autowired
    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    public Iterable<Libro> findAll() {
        return libroRepository.findAll();
    }

    public List<Libro> findByAuthorLastName(String lastName) {
        return libroRepository.findByAutorLastName(lastName);
    }

    public List<Libro> findByTitleContaining(String word) {
        return libroRepository.findByTitleContaining(word);
    }

    public List<Libro> findFiveWithMostPagesOrderedDesc() {
        return libroRepository.findTop5ByOrderByAmountPagesDesc();
    }

    public List<Libro> findByYearBefore(Integer year) {
        return libroRepository.findByReleaseYearBefore(year);
    }

    public List<Libro> findByEditorialIgnoreCase(String editorial) {
        return libroRepository.findByEditorialIgnoreCase(editorial);
    }
}
