package com.example.showroom.service;

import com.example.showroom.dto.request.ClothesDTO;
import com.example.showroom.dto.response.ClothesDTOResponse;
import com.example.showroom.dto.response.MessageDTO;
import com.example.showroom.dto.response.UpdateClothesDTO;

import java.util.List;

public interface IClothesService {

    MessageDTO create(ClothesDTO clothesDTO);
    List<ClothesDTOResponse> getAll();
    List<ClothesDTOResponse> getAllClothesBySize(String size);
    ClothesDTOResponse getClothesById(Long id);

    List<ClothesDTOResponse> getAllClothesByName(String name);

    UpdateClothesDTO updateClothesById(Long id, ClothesDTO clothesDTO);
    MessageDTO deleteClothesById(Long id);

}
