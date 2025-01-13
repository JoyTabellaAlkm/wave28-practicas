package com.mercadolibre.ejerciciojpajoyas.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mercadolibre.ejerciciojpajoyas.Entity.Jewelry;
import com.mercadolibre.ejerciciojpajoyas.dto.CreateJewelryDTO;
import com.mercadolibre.ejerciciojpajoyas.dto.EditJewelryDTO;
import com.mercadolibre.ejerciciojpajoyas.dto.JewelryDTO;
import com.mercadolibre.ejerciciojpajoyas.dto.MessageDTO;
import com.mercadolibre.ejerciciojpajoyas.exception.NotFoundException;
import com.mercadolibre.ejerciciojpajoyas.repository.IJewelryRepository;
import com.mercadolibre.ejerciciojpajoyas.service.IJewelryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JewelryService implements IJewelryService {

    IJewelryRepository jewelryRepository;

    ModelMapper modelMapper = new ModelMapper();

    public JewelryService(IJewelryRepository jewelryRepository) {
        this.jewelryRepository = jewelryRepository;
    }

    @Override
    public MessageDTO createJewelry(CreateJewelryDTO createJewelryDTO) {
        Jewelry jewelry = modelMapper.map(createJewelryDTO, Jewelry.class);
        jewelry.setForSale(true);
        Long  id = jewelryRepository.save(jewelry).getId();
        return new MessageDTO("La joya con id " + id + " se ha creado correctamente.");
    }

    @Override
    public List<JewelryDTO> getAllJewelry() {
        List<Jewelry> jewelryList = jewelryRepository.findAll()
                .stream()
                .filter(Jewelry::getForSale)
                .toList();
        return jewelryList.stream().map(j -> modelMapper.map(j, JewelryDTO.class)).toList();
    }

    @Override
    public MessageDTO softDeleteJewelry(Long id) {
        Jewelry jewelry = jewelryRepository.findById(id).orElse(null);
        if(jewelry == null) {
            throw new NotFoundException("No se ha encontrado la joya con id " + id);
        }
        jewelry.setForSale(false);
        jewelryRepository.save(jewelry);
        return new MessageDTO("La joya se ha eliminado correctamente.");
    }

    @Override
    public JewelryDTO editJewelry(Long id, EditJewelryDTO editJewelryDTO) {
        Jewelry jewelry = jewelryRepository.findById(id).orElse(null);
        if(jewelry == null) {
            throw new NotFoundException("No se ha encontrado la joya con id " + id);
        }

        jewelry.setName(editJewelryDTO.getName());
        jewelry.setMaterial(editJewelryDTO.getMaterial());
        jewelry.setDescription(editJewelryDTO.getDescription());
        jewelry.setWeight(editJewelryDTO.getWeight());
        jewelry.setHasStone(editJewelryDTO.getHasStone());

        jewelryRepository.save(jewelry);
        return modelMapper.map(jewelry, JewelryDTO.class);
    }

}
