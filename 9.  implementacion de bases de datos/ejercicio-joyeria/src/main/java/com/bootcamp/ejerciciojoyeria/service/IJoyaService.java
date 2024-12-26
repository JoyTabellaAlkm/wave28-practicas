package com.bootcamp.ejerciciojoyeria.service;

import com.bootcamp.ejerciciojoyeria.dto.*;

import java.util.List;

public interface IJoyaService {
    ResponsePostDto createJewel(RequestJoyaDto requestJoyaDto);

    List<ResponseJoyaDto> getAllJewels();

    boolean deleteJewel(Long id);

    UpdateJoyaDto updateJewel(Long id, UpdateJoyaDto updateJoyaDto);
}
