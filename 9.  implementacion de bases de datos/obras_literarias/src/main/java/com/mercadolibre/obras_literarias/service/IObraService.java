package com.mercadolibre.obras_literarias.service;

import com.mercadolibre.obras_literarias.dto.CreateObraDto;
import com.mercadolibre.obras_literarias.entity.Obra;

public interface IObraService {

    public Obra save(CreateObraDto obra);

    public Iterable<Obra> findAll();

    public Iterable<Obra> findAllByAutor(String autor);

    public Iterable<Obra> findAllByNombreLike(String query);

    public Iterable<Obra> findTop5MostCantidadPaginas();

    public Iterable<Obra> findAllByAnioPublicacionDown(int anioPublicacion);

    public Iterable<Obra> findAllByEditorial(String editorial);

}
