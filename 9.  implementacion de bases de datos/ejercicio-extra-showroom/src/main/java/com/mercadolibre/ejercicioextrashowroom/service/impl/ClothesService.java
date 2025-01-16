package com.mercadolibre.ejercicioextrashowroom.service.impl;

import com.mercadolibre.ejercicioextrashowroom.dto.request.CreateClothesDTO;
import com.mercadolibre.ejercicioextrashowroom.dto.response.ClothesDTO;
import com.mercadolibre.ejercicioextrashowroom.dto.response.MessageDTO;
import com.mercadolibre.ejercicioextrashowroom.entity.Clothes;
import com.mercadolibre.ejercicioextrashowroom.exception.NotFoundException;
import com.mercadolibre.ejercicioextrashowroom.repository.IClothesRepository;
import com.mercadolibre.ejercicioextrashowroom.service.IClothesService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClothesService implements IClothesService {


    IClothesRepository clothesRepository;

    ModelMapper modelMapper = new ModelMapper();

    public ClothesService(IClothesRepository clothesRepository) {
        this.clothesRepository = clothesRepository;
    }


    @Override
    public MessageDTO createClothes(CreateClothesDTO clothesDTO) {
        Clothes clothes = clothesRepository.save(modelMapper.map(clothesDTO, Clothes.class));
        return new MessageDTO("Se ha creado la prenda con el código " + clothes.getId());
    }

    @Override
    public List<ClothesDTO> getAllClothes() {
        List<Clothes> clothes = clothesRepository.findAll();
        return mapClothesListToDTOList(clothes);
    }

    @Override
    public ClothesDTO getClothesById(Long id) {
        Clothes clothes = findClothesById(id);
        return modelMapper.map(clothes, ClothesDTO.class);
    }

    @Override
    public MessageDTO updateClothes(Long id, CreateClothesDTO clothesDTO) {
        Clothes clothes = findClothesById(id);
        updateClothes(clothes, clothesDTO);
        clothesRepository.save(clothes);
        return new MessageDTO("Prenda actualizada correctamente.");
    }

    @Override
    public MessageDTO deleteClothes(Long id) {
        clothesRepository.deleteById(id);
        return new MessageDTO("Prenda eliminada correctamente");
    }

    @Override
    public List<ClothesDTO> getClothesBySize(String size) {
        List<Clothes> clothes = clothesRepository.findClothesBySize(size);
        return mapClothesListToDTOList(clothes);
    }

    @Override
    public List<ClothesDTO> searchClothesByName(String query) {
        List<Clothes> clothes = clothesRepository.searchClothesByName("%" + query + "%");
        return mapClothesListToDTOList(clothes);
    }



    private Clothes findClothesById(Long id) {
        return clothesRepository.findById(id)
                .orElseThrow(
                        () -> new NotFoundException("No se ha encontrado la prenda solicitada.")
                );
    }

    private List<ClothesDTO> mapClothesListToDTOList(List<Clothes> clothes) {
        return clothes
                .stream()
                .map(c -> modelMapper.map(c, ClothesDTO.class))
                .toList();
    }

    private void updateClothes(Clothes clothes, CreateClothesDTO clothesDTO) {
        if(clothesDTO.getName() != null) {
            clothes.setName(clothesDTO.getName());
        }

        if(clothesDTO.getType() != null) {
            clothes.setType(clothesDTO.getType());
        }

        if(clothesDTO.getBrand() != null) {
            clothes.setBrand(clothesDTO.getBrand());
        }

        if(clothesDTO.getColor() != null) {
            clothes.setColor(clothesDTO.getColor());
        }
    }

}
