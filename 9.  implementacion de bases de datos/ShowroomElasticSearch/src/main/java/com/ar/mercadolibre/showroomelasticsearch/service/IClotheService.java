package com.ar.mercadolibre.showroom.service;

import com.ar.mercadolibre.showroom.dto.ClotheDTO;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface IClotheService {
    ClotheDTO create(ClotheDTO clotheDTO);
    List<ClotheDTO> getClothes(String name);
    ClotheDTO getById(Long code);
    ClotheDTO update(Long code, ClotheDTO clotheDTO);
    void delete(Long code);
    List<ClotheDTO> getBySize(String size);
}
