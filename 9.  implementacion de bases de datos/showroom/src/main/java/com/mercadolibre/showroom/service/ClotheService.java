package com.mercadolibre.showroom.service;

import com.mercadolibre.showroom.dto.ClotheDTO;
import com.mercadolibre.showroom.entity.Clothe;
import com.mercadolibre.showroom.exception.NotFoundException;
import com.mercadolibre.showroom.repository.IClotheRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClotheService implements IClotheService{

    @Autowired
    private IClotheRepository clotheRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public ClotheDTO create(ClotheDTO clotheDTO) {
        Clothe clothe = modelMapper.map(clotheDTO, Clothe.class);
        Clothe newClothe = this.clotheRepository.save(clothe);
        clotheDTO.setId(newClothe.getId());
        return clotheDTO;
    }

    @Override
    public List<ClotheDTO> findAll() {
        List<Clothe> clothes = this.clotheRepository.findAll();
        return clothes.stream().map(clothe -> modelMapper.map(clothe, ClotheDTO.class)).toList();
    }

    @Override
    public ClotheDTO findClotheByCode(String code) {
        Clothe clothe = this.clotheRepository.findClotheByCode(code);
        if(clothe == null) throw new NotFoundException("No se encontró ninguna prenda para el codigo: " + code);

        return modelMapper.map(clothe,ClotheDTO.class);
    }

    @Override
    public ClotheDTO update(String code, ClotheDTO clotheDTO) {
        ClotheDTO clothe = findClotheByCode(code);
        clotheDTO.setId(clothe.getId());

        Clothe updatedClothe = modelMapper.map(clotheDTO, Clothe.class);
        this.clotheRepository.save(updatedClothe);

        return clotheDTO;
    }

    @Override
    public ClotheDTO delete(String code) {
        ClotheDTO clotheDto = findClotheByCode(code);
        Clothe clothe = modelMapper.map(clotheDto, Clothe.class);
        this.clotheRepository.delete(clothe);
        return clotheDto;
    }

    @Override
    public List<ClotheDTO> findClotheBySize(Float size) {
        List<Clothe> clothes = this.clotheRepository.findClotheBySize(size);

        return clothes.stream().map(clothe -> modelMapper.map(clothe, ClotheDTO.class)).toList();
    }

    @Override
    public List<ClotheDTO> findClotheByName(String name) {
        List<Clothe> clothes = this.clotheRepository.findClotheByName(name);
        return clothes.stream().map(clothe -> modelMapper.map(clothe, ClotheDTO.class)).toList();
    }

    public Clothe findById(ClotheDTO clotheDTO) {
        return clotheRepository.findById(clotheDTO.getId())
                .orElse(null);
    }

}
