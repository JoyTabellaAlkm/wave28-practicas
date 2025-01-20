package com.mercadolibre.showroom.service;

import com.mercadolibre.showroom.dto.PrendaCreateDTO;
import com.mercadolibre.showroom.dto.PrendaDTO;
import com.mercadolibre.showroom.entity.Prenda;

import java.util.List;

public interface IPrendaService {
    PrendaDTO create(PrendaCreateDTO prenda);
    List<PrendaDTO> getAll(String name);
    PrendaDTO getPrendaByCode(Long code);
    PrendaDTO updatePrendaByCode(Long code, PrendaCreateDTO prenda);
    void deletePrenda(Long code);
    List<PrendaDTO> findByTalle(String talle);
    //List<PrendaDTO> findAllByNombreIgnoreCaseContaining(String nombre);

}
