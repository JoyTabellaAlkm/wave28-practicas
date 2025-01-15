package com.bootcamp.clothes.service;

import com.bootcamp.clothes.entity.Clothe;
import com.bootcamp.clothes.repository.IClotheRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClotheService implements IClotheService {
    private final IClotheRepository clotheRepository;

    public ClotheService(IClotheRepository clotheRepository) {
        this.clotheRepository = clotheRepository;
    }

    @Override
    public Clothe createClothe(Clothe Clothe) {
        return clotheRepository.save(Clothe);
    }

    @Override
    public List<Clothe> getAllClothes() {
        return clotheRepository.findAll();
    }

    @Override
    public Clothe getClotheByCode(Long code) {
        return clotheRepository.findByCode(code);
    }

    @Override
    public List<Clothe> getClothesBySize(String size) {
        return clotheRepository.findBySize(size);
    }

    @Override
    public List<Clothe> getClothesByNameContains(String name) {
        return clotheRepository.findByNameContainingIgnoreCase(name);
    }

    @Override
    public Clothe updateClothe(Long code, Clothe updatedClothe) {
        Clothe existingClothe = clotheRepository.findByCode(code);
        if (existingClothe == null) return null;

        existingClothe.setName(updatedClothe.getName());
        existingClothe.setType(updatedClothe.getType());
        existingClothe.setBrand(updatedClothe.getBrand());
        existingClothe.setColor(updatedClothe.getColor());
        existingClothe.setSize(updatedClothe.getSize());
        existingClothe.setQuantity(updatedClothe.getQuantity());
        existingClothe.setSalePrice(updatedClothe.getSalePrice());

        return clotheRepository.save(existingClothe);
    }

    @Override
    public boolean deleteClothe(Long code) {
        Clothe existingClothe = clotheRepository.findByCode(code);
        if (existingClothe == null) return false;

        clotheRepository.delete(existingClothe);
        return true;
    }
}