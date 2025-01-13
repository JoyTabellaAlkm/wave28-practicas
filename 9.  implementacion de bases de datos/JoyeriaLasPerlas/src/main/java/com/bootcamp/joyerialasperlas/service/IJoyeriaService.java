package com.bootcamp.joyerialasperlas.service;

import com.bootcamp.joyerialasperlas.dto.request.CreateJoyaDTO;
import com.bootcamp.joyerialasperlas.dto.response.JoyaDTO;
import com.bootcamp.joyerialasperlas.dto.response.ResponseDTO;

import java.util.List;

public interface IJoyeriaService {
    ResponseDTO agregarJoya(CreateJoyaDTO createJoyaDTO);

    List<JoyaDTO> obtenerJoyas();
}
