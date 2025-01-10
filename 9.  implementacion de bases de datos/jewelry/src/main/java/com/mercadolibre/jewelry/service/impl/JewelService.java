package com.mercadolibre.jewelry.service.impl;

import com.mercadolibre.jewelry.dto.request.JewelRequestDto;
import com.mercadolibre.jewelry.dto.response.JewelResponseDto;
import com.mercadolibre.jewelry.entity.Jewel;
import com.mercadolibre.jewelry.exception.NotFoundException;
import com.mercadolibre.jewelry.repository.IJewelRepository;
import com.mercadolibre.jewelry.service.IJewelService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JewelService implements IJewelService {
    private final IJewelRepository jewelRepository;
    private final ModelMapper mapper;

    public JewelService(IJewelRepository jewelRepository, ModelMapper mapper) {
        this.jewelRepository = jewelRepository;
        this.mapper = mapper;
    }

    @Override
    public JewelResponseDto save(JewelRequestDto jewelRequestDto) {
        Jewel jewel = jewelRepository.save(mapper.map(jewelRequestDto, Jewel.class));
        return mapper.map(jewel, JewelResponseDto.class);
    }

    @Override
    public List<JewelResponseDto> findAll() {
        return jewelRepository.findAll().stream()
                .filter(jewel -> jewel.getSaleOrNot().equals(true))
                .map(jewel -> mapper.map(jewel, JewelResponseDto.class))
                .toList();
    }

    @Override
    public JewelResponseDto findById(Long id) {
        Jewel jewel = jewelRepository.findById(id).orElseThrow(
                () -> new NotFoundException("No se encontró la joya con id " + id)
        );
        return mapper.map(jewel, JewelResponseDto.class);
    }

    @Override
    public JewelResponseDto update(Long id, JewelRequestDto jewelRequestDto) {
        Jewel existingJewel = mapper.map(findById(id), Jewel.class);
        mapper.map(jewelRequestDto, existingJewel);
        existingJewel.setId(id);

        return mapper.map(jewelRepository.save(existingJewel), JewelResponseDto.class);
    }

    @Override
    public JewelResponseDto delete(Long id) {
        Jewel existingJewel = mapper.map(findById(id), Jewel.class);
        existingJewel.setSaleOrNot(false);
        return mapper.map(jewelRepository.save(existingJewel), JewelResponseDto.class);
    }
}
