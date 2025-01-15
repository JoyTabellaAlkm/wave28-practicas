package com.bootcamp.clothes.service;

import com.bootcamp.clothes.entity.Clothe;

import java.util.List;

public interface IClotheService {
    Clothe createClothe(Clothe Clothe);

    List<Clothe> getAllClothes();

    Clothe getClotheByCode(Long code);

    List<Clothe> getClothesBySize(String size);

    List<Clothe> getClothesByNameContains(String name);

    Clothe updateClothe(Long code, Clothe updatedClothe);

    boolean deleteClothe(Long code);
}
