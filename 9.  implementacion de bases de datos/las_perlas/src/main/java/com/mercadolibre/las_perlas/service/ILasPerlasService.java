package com.mercadolibre.las_perlas.service;

import com.mercadolibre.las_perlas.dto.JoyaDTO;
import jakarta.validation.Valid;

import java.util.List;

public interface ILasPerlasService {
    List<JoyaDTO> findAll();
    JoyaDTO findById(Long id);
    JoyaDTO create(JoyaDTO joyaDTO);
    JoyaDTO update(Long id, @Valid JoyaDTO joyaDTO);
    JoyaDTO delete(Long id);
}
