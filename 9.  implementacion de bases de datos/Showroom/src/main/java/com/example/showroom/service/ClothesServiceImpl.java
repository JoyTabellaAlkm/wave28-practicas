package com.example.showroom.service;

import com.example.showroom.dto.request.ClothesDTO;
import com.example.showroom.dto.response.ClothesDTOResponse;
import com.example.showroom.dto.response.MessageDTO;
import com.example.showroom.dto.response.UpdateClothesDTO;
import com.example.showroom.entity.Clothes;
import com.example.showroom.exception.NotFoundException;
import com.example.showroom.repository.ClothesRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothesServiceImpl implements IClothesService{

    @Autowired
    private ClothesRepository clothesRepository;

    @Autowired
    private ObjectMapper mapper;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MessageDTO create(ClothesDTO clothesDTO) {
        Clothes newClothes = mapper.convertValue(clothesDTO, Clothes.class);
        clothesRepository.save(newClothes);
        return new MessageDTO("creado", 201);
    }

    @Override
    public List<ClothesDTOResponse> getAll() {
        List<Clothes> clothesList = clothesRepository.findAll();
        if (clothesList.isEmpty()) {
            throw new NotFoundException("No se encontraron registros de ropa.");
        }
        return clothesList.stream()
                .map(c -> mapper.convertValue(c, ClothesDTOResponse.class))
                .toList();
    }

    @Override
    public List<ClothesDTOResponse> getAllClothesBySize(String size) {
        List<Clothes> clothesList = clothesRepository.findAllBySize(size);
        if (clothesList.isEmpty()) {
            throw new NotFoundException("No se encontraron registros de ropa.");
        }
        return clothesList.stream()
                .map(c -> mapper.convertValue(c, ClothesDTOResponse.class))
                .toList();
    }

    @Override
    public ClothesDTOResponse getClothesById(Long id) {
        Clothes clothes = clothesRepository.findById(id)
                .orElseThrow(()-> new NotFoundException("No se encuentran registros de ropa"));
        return mapper.convertValue(clothes, ClothesDTOResponse.class);
    }

    @Override
    public List<ClothesDTOResponse> getAllClothesByName(String name) {
        List<Clothes> clothes = clothesRepository.findAllByNameContaining(name);
        if(clothes.isEmpty()) throw new NotFoundException("no se encontraron resultados");

        return clothes.stream()
                .map(c->modelMapper.map(c, ClothesDTOResponse.class))
                .toList();
    }

    @Override
    public UpdateClothesDTO updateClothesById(Long id, ClothesDTO clothesDTO) {
        Clothes existingClothes = clothesRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Ropa no encontrada"));
        modelMapper.map(clothesDTO, existingClothes);

        Clothes updatedClothes = clothesRepository.save(existingClothes);
        ClothesDTOResponse updatedClothesDTO = modelMapper.map(updatedClothes, ClothesDTOResponse.class);
        UpdateClothesDTO response  = new UpdateClothesDTO(updatedClothesDTO, new MessageDTO("actualizado", 204));
        return response;
    }


    @Override
    public MessageDTO deleteClothesById(Long id) {
        boolean exists = clothesRepository.existsById(id);
        if(!exists) new NotFoundException("No se encuentran registros de ropa");
        clothesRepository.deleteById(id);
        return new MessageDTO("se borró correctamente", 205);
    }

}
