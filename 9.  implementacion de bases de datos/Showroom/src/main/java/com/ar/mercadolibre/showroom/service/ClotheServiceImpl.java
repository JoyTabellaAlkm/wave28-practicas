package com.ar.mercadolibre.showroom.service;

import com.ar.mercadolibre.showroom.dto.ClotheDTO;
import com.ar.mercadolibre.showroom.entity.Clothe;
import com.ar.mercadolibre.showroom.exceptions.NotFoundException;
import com.ar.mercadolibre.showroom.repository.IClotheRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClotheServiceImpl implements IClotheService{

    private final IClotheRepository clotheRepository;
    private final ModelMapper mapper;

    public ClotheServiceImpl(IClotheRepository clotheRepository, ModelMapper mapper) {
        this.clotheRepository = clotheRepository;
        this.mapper = mapper;
    }

    @Override
    public ClotheDTO create(ClotheDTO clotheDTO) {
        Clothe clotheToCreate = mapper.map(clotheDTO, Clothe.class);
        Clothe createdClothe = clotheRepository.save(clotheToCreate);

        return mapper.map(createdClothe, ClotheDTO.class);
    }

    @Override
    public List<ClotheDTO> getClothes(String name) {
        List<Clothe> clothes;
        if(name == null) {
            clothes = clotheRepository.findAll();
        }
        else {
            clothes = clotheRepository.findByNombreContainingIgnoreCase(name);
        }

        if(clothes.isEmpty()) {
            throw new NotFoundException("No se encontraron prendas con ese nombre");
        }

        return clothes.stream().map(clothe -> mapper.map(clothe, ClotheDTO.class)).toList();
    }

    @Override
    public ClotheDTO getById(Long code) {
        Clothe clothe = validateClotheCode(code);
        return mapper.map(clothe, ClotheDTO.class);
    }

    @Override
    public ClotheDTO update(Long code, ClotheDTO clotheDTO) {
        validateClotheCode(code);
        clotheDTO.setCodigo(code);
        Clothe clotheToUpdate = mapper.map(clotheDTO, Clothe.class);

        return mapper.map(clotheRepository.save(clotheToUpdate), ClotheDTO.class);
    }

    @Override
    public void delete(Long code) {
        Clothe clotheToDelete = validateClotheCode(code);
        clotheRepository.delete(clotheToDelete);
    }

    @Override
    public List<ClotheDTO> getBySize(String size) {
        List<Clothe> clothes = clotheRepository.findByTalla(size);
        if(clothes.isEmpty()) {
            throw new NotFoundException("No se encontraron prendas de esa talla");
        }

        return clothes.stream().map(clothe -> mapper.map(clothe, ClotheDTO.class)).toList();
    }

    private Clothe validateClotheCode(Long code) {
        Optional<Clothe> clothe = clotheRepository.findById(code);
        if(clothe.isEmpty()) {
            throw new NotFoundException("No se encontro una prenda con ese código");
        }

        return clothe.get();
    }
}
