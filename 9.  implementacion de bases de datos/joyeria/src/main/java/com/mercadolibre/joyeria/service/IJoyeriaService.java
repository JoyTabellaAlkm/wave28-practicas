package com.mercadolibre.joyeria.service;

import com.mercadolibre.joyeria.dto.JoyaDto;
import com.mercadolibre.joyeria.model.Joya;

import java.util.List;

public interface IJoyeriaService {
    public List<JoyaDto> obtenerJoyas();
    public Long guardaJoya(JoyaDto joyaDto);
    public void eliminarJoya(Long nroIdentificador);
    public JoyaDto buscarJoya(Long nroIdentificador);
    public JoyaDto actualizarJoya(Long nroIdentificador,JoyaDto joyaDto);
}
