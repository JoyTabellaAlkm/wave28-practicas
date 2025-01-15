package com.bootcamp.Showroom.service.impl;

import com.bootcamp.Showroom.dto.ClothDto;
import com.bootcamp.Showroom.entity.Cloth;
import com.bootcamp.Showroom.repository.IClothRepository;
import com.bootcamp.Showroom.service.IClothService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothService implements IClothService {

    private final IClothRepository clothRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public ClothService(IClothRepository clothRepository) {
        this.clothRepository = clothRepository;
    }

    @Override
    public void create(ClothDto dto) {
        Cloth cloth = new Cloth();
        modelMapper.map(dto, cloth);
        clothRepository.save(cloth);
    }

    @Override
    public List<ClothDto> getAllClothes() {
        return clothRepository.findAll().stream()
                .map(cloth -> modelMapper.map(cloth, ClothDto.class))
                .toList();
    }

    @Override
    public ClothDto getClothByCode(Integer code) {
        return modelMapper.map(clothRepository.findByCode(code), ClothDto.class);
    }

    @Override
    public void updateCloth(Integer code, ClothDto dto) {
        Cloth cloth = clothRepository.findByCode(code);
        modelMapper.map(dto,cloth);
        clothRepository.save(cloth);
    }

    @Override
    public void deleteCloth(Integer code) {
        clothRepository.deleteByCode(code);
    }

    @Override
    public List<ClothDto> getClothesBySize(String size) {
        return clothRepository.findClothsBySize(size).stream()
                .map(cloth -> modelMapper.map(cloth,ClothDto.class))
                .toList();
    }

    @Override
    public List<ClothDto> getClothesByName(String name) {
        return clothRepository.findClothsByName(name).stream()
                .map(cloth -> modelMapper.map(cloth,ClothDto.class))
                .toList();
    }
}
