package com.mercadolibre.joyerialasperlas.service;

import com.mercadolibre.joyerialasperlas.entity.Joya;

import java.util.List;

public interface IJoyaService {

    Long createJoya(Joya joya);
    List<Joya> getAllJoyas();
    Joya getJoyaById(Long id);
    void deleteJoya(Long id);
    Joya updateJoya(Long id,Joya joya);

}
