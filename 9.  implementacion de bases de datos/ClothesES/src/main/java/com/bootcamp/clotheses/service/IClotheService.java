package com.bootcamp.clotheses.service;

import com.bootcamp.clotheses.model.Clothe;

import java.util.List;

public interface IClotheService {
    Clothe createClothe(Clothe Clothe);

    List<Clothe> getAllClothes();

    Clothe getClotheByCode(String code);

    List<Clothe> getClothesBySize(String size);

    List<Clothe> getClothesByNameContains(String name);

    Clothe updateClothe(String code, Clothe updatedClothe);

    boolean deleteClothe(String code);
}
