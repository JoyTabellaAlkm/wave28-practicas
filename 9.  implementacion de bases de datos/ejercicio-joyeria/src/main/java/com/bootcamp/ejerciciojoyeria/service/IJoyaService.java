package com.bootcamp.ejerciciojoyeria.service;

import com.bootcamp.ejerciciojoyeria.dto.JoyaDto;

import java.util.List;

public interface IJoyaService {
    Long createJewel(JoyaDto joyaDto);

    List<JoyaDto> getAllJewels();

    void deleteJewel(Long id);

    JoyaDto updateJewel(Long idUpdate, JoyaDto joyaDto);
}
