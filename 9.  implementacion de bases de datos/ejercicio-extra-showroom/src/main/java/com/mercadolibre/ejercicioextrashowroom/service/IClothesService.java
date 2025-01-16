package com.mercadolibre.ejercicioextrashowroom.service;

import com.mercadolibre.ejercicioextrashowroom.dto.request.CreateClothesDTO;
import com.mercadolibre.ejercicioextrashowroom.dto.response.ClothesDTO;
import com.mercadolibre.ejercicioextrashowroom.dto.response.MessageDTO;

import java.util.List;

public interface IClothesService {

    MessageDTO createClothes(CreateClothesDTO clothesDTO);

    List<ClothesDTO> getAllClothes();

    ClothesDTO getClothesById(Long id);

    MessageDTO updateClothes(Long id, CreateClothesDTO clothesDTO);

    MessageDTO deleteClothes(Long id);

    List<ClothesDTO> getClothesBySize(String size);

    List<ClothesDTO> searchClothesByName(String query);


}
