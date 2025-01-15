package com.mercadolibre.showroom.service;

import com.mercadolibre.showroom.dto.ClotheDTO;

import java.util.List;

public interface IClotheService {
    ClotheDTO create(ClotheDTO clotheDTO);
    List<ClotheDTO> findAll();
    ClotheDTO findClotheByCode(String code);
    ClotheDTO update(String code, ClotheDTO clotheDTO);
    ClotheDTO delete(String code);
    List<ClotheDTO> findClotheBySize(Float size);
    List<ClotheDTO> findClotheByName(String name);
}
