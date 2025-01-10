package com.mercadolibre.jewelry.service;

import com.mercadolibre.jewelry.dto.request.JewelRequestDto;
import com.mercadolibre.jewelry.dto.response.JewelResponseDto;

import java.util.List;

public interface IJewelService {
    JewelResponseDto save(JewelRequestDto jewelRequestDto);

    List<JewelResponseDto> findAll();

    JewelResponseDto findById(Long id);

    JewelResponseDto update(Long id, JewelRequestDto jewelRequestDto);

    JewelResponseDto delete(Long id);
}
