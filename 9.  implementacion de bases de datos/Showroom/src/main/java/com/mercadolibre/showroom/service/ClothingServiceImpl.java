package com.mercadolibre.showroom.service;

import com.mercadolibre.showroom.dto.ClothingDTO;
import com.mercadolibre.showroom.dto.responses.MessageDTO;
import com.mercadolibre.showroom.exception.NotFoundException;
import com.mercadolibre.showroom.model.Clothing;
import com.mercadolibre.showroom.repository.IClothingRepository;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

@Service
public class ClothingServiceImpl implements IClothingService {

    private final IClothingRepository clothingRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public ClothingServiceImpl(IClothingRepository clothingRepository) {
        this.clothingRepository = clothingRepository;
    }

    @Override
    public List<ClothingDTO> getClothings() {
        return clothingRepository.findAll().stream()
                .map(clothing -> modelMapper.map(clothing, ClothingDTO.class))
                .toList();
    }

    @Override
    public ClothingDTO saveClothing(ClothingDTO clothingDTO) {
        clothingRepository.save(modelMapper.map(clothingDTO, Clothing.class));
        return clothingDTO;
    }

    @Override
    public ClothingDTO findClothingByCode(Long code) {
        return clothingRepository.findById(code)
                .map(clothing -> modelMapper.map(clothing, ClothingDTO.class))
                .orElse(null);
    }

    @Override
    public ClothingDTO updateClothin(Long id, ClothingDTO clothingDTO) {

        Optional<Clothing> clothingToUpdate = clothingRepository.findById(id);

        if (clothingToUpdate.isEmpty()) {
            throw new NotFoundException("Clothing does not exist");
        }

        Clothing testCaseToUpdate = clothingToUpdate.get();
        testCaseToUpdate.setName(clothingDTO.getName());
        testCaseToUpdate.setType(clothingDTO.getType());
        testCaseToUpdate.setBrand(clothingDTO.getBrand());
        testCaseToUpdate.setColor(clothingDTO.getColor());
        testCaseToUpdate.setSize(clothingDTO.getSize());
        testCaseToUpdate.setStock(clothingDTO.getStock());
        testCaseToUpdate.setPrice(clothingDTO.getPrice());

        clothingRepository.save(testCaseToUpdate);

        return clothingDTO;
    }

    @Override
    public MessageDTO deleteClothing(Long id) {

        Optional<Clothing> clothingToDelete = clothingRepository.findById(id);

        if (clothingToDelete.isEmpty()) {
            throw new NotFoundException("Clothing does not exist");
        }

        clothingRepository.deleteById(id);
        return new MessageDTO("Clothing deleted");
    }

    @Override
    public List<ClothingDTO> findBySize(String size) {
        return clothingRepository.findBySizeIgnoreCase(size).stream()
                .map(clothing -> modelMapper.map(clothing, ClothingDTO.class))
                .toList();
    }

    @Override
    public List<ClothingDTO> findByNameContaining(String name) {
        return clothingRepository.findByNameContainingIgnoreCase(name).stream()
                .map(clothing -> modelMapper.map(clothing, ClothingDTO.class))
                .toList();
    }

}
