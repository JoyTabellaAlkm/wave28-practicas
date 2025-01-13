package com.example.JoyeriaLasPerlas.service;

import com.example.JoyeriaLasPerlas.dtos.JoyaDto;
import com.example.JoyeriaLasPerlas.dtos.RespuestaDto;

import java.util.List;

public interface IJoyaService {
    RespuestaDto agregarJoya(JoyaDto joyaDto);
    RespuestaDto actualizarJoya(Integer Id, JoyaDto joyaDto);
    List<JoyaDto> listarJoyas();
    RespuestaDto eliminarJoya(Integer id);
}
