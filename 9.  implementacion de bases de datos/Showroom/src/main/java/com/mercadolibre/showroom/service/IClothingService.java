package com.mercadolibre.showroom.service;

import com.mercadolibre.showroom.dto.ClothingDTO;
import com.mercadolibre.showroom.dto.responses.MessageDTO;

import java.util.List;

public interface IClothingService {

    List<ClothingDTO> getClothings();
    ClothingDTO saveClothing(ClothingDTO clothingDTO);
    ClothingDTO findClothingByCode(Long code);
    ClothingDTO updateClothin(Long id, ClothingDTO clothingDTO);
    MessageDTO deleteClothing(Long id);
    List<ClothingDTO> findBySize(String size);
    List<ClothingDTO> findByNameContaining(String name);
}
