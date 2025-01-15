package com.bootcamp.ejercicio_showroom.service;

import com.bootcamp.ejercicio_showroom.model.Clothes;
import com.bootcamp.ejercicio_showroom.repository.ClothesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClothesService {
    @Autowired
    private ClothesRepository clothesRepository;

    public Clothes createClothes(Clothes clothes) {
        return clothesRepository.save(clothes);
    }

    public List<Clothes> getAllClothes() {
        return clothesRepository.findAll();
    }

    public Optional<Clothes> getClothesByCode(String code) {
        return clothesRepository.findByCode(code);
    }

    public Clothes updateClothes(String code, Clothes clothesDetails) {
        Clothes existingClothes = clothesRepository.findByCode(code).orElseThrow(() -> new RuntimeException("Clothes not found"));
        existingClothes.setName(clothesDetails.getName());
        existingClothes.setType(clothesDetails.getType());
        existingClothes.setBrand(clothesDetails.getBrand());
        existingClothes.setColor(clothesDetails.getColor());
        existingClothes.setSize(clothesDetails.getSize());
        existingClothes.setQuantity(clothesDetails.getQuantity());
        existingClothes.setPrice(clothesDetails.getPrice());
        return clothesRepository.save(existingClothes);
    }
    @Transactional
    public void deleteClothes(String code) {
        clothesRepository.deleteByCode(code);
    }

    public List<Clothes> getClothesBySize(String size) {
        return clothesRepository.findBySize(size);
    }

    public List<Clothes> searchClothesByName(String name) {
        return clothesRepository.findByNameContainingIgnoreCase(name);
    }
}
