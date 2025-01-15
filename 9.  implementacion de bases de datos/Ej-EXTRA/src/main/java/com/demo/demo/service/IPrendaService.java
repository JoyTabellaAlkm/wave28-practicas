package com.demo.demo.service;

import com.demo.demo.dto.PrendaDTO;

import java.util.List;

public interface IPrendaService {
    PrendaDTO save(PrendaDTO prenda);
    List<PrendaDTO> findAll();
    PrendaDTO findById(String id);
    PrendaDTO delete(String id);
    List<PrendaDTO> findAllByName(String name);
}
