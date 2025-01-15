package com.bootcamp.LasPerlas.service;

import com.bootcamp.LasPerlas.dto.JoyaDto;
import com.bootcamp.LasPerlas.dto.MensajeDto;
import com.bootcamp.LasPerlas.model.Joya;

import java.util.List;

public interface IJoyaService {

    public MensajeDto saveJoya(JoyaDto joya);
    public List<JoyaDto> getJoyas();
    public JoyaDto findJoya(Long id);
    public MensajeDto deleteJoya(Long id);
    public MensajeDto editJoya(Long id_modificar, JoyaDto joya_modif);

}
