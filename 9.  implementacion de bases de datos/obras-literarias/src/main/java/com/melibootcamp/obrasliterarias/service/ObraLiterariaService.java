package com.melibootcamp.obrasliterarias.service;

import com.melibootcamp.obrasliterarias.entity.ObraLiteraria;

import java.util.List;
import java.util.Optional;

public interface ObraLiterariaService {
    public ObraLiteraria save (ObraLiteraria obra);

    public List<ObraLiteraria> findAll();

    public Optional<ObraLiteraria> findById(String id);

    public String delete (String id);

    public String update (ObraLiteraria obra, String id);

    //-- Consignas
    public List<ObraLiteraria> findByAuthor(String author);
    public List<ObraLiteraria> findByPatternInTitle(String pattern);
    public List<ObraLiteraria> findTop5BooksWithMostPagesAscOrder();

    public List<ObraLiteraria> findBooksSoldPriorToSentYear(Integer year);

    public List<ObraLiteraria> findByEditorial(String editorial);
}
