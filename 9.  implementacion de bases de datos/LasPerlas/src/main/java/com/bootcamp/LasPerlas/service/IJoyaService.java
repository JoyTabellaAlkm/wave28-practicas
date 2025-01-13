package com.bootcamp.LasPerlas.service;

import com.bootcamp.LasPerlas.dto.MensajeDto;
import com.bootcamp.LasPerlas.model.Joya;

import java.util.List;

public interface IJoyaService {

    public MensajeDto saveJoya(Joya joya);
    public List<Joya> getJoyas();
    public Joya findJoya(Long id);
    public MensajeDto deleteJoya(Long id);
    public MensajeDto editJoya(Long id_modificar, Joya joya_modif);

}
