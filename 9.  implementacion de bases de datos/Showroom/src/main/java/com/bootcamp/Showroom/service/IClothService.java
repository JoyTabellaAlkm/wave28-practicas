package com.bootcamp.Showroom.service;

import com.bootcamp.Showroom.dto.ClothDto;

import java.util.List;

public interface IClothService {
    void create(ClothDto dto);
    List<ClothDto> getAllClothes();
    ClothDto getClothByCode(Integer code);
    void updateCloth(Integer code, ClothDto dto);
    void deleteCloth(Integer code);
    List<ClothDto> getClothesBySize(String size);
    List<ClothDto> getClothesByName(String name);
}
