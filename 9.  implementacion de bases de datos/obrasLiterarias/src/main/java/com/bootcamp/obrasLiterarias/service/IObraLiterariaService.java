package com.bootcamp.obrasLiterarias.service;

import com.bootcamp.obrasLiterarias.model.ObraLiteraria;

import java.util.List;
import java.util.Optional;

public interface IObraLiterariaService {
    public ObraLiteraria save (ObraLiteraria obra);
    public List<ObraLiteraria> findAll();
    public Optional<ObraLiteraria> findById(Long id);
    public String deleteObra (Long id);
    public String editObra (ObraLiteraria obra);
}
