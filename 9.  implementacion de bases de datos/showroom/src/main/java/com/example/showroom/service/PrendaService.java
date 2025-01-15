package com.example.showroom.service;

import com.example.showroom.dto.PrendaDto;

import java.util.List;

public interface PrendaService {

    Long postPrenda(PrendaDto prendaDto);
    List<PrendaDto> getPrendas();
    PrendaDto findPrendaCode(Long code);
    Long putPrenda(Long code, PrendaDto prendaDto);
    Long deletePrenda(Long code);
    List<PrendaDto> findPrendasNombre(String nombre);
    List<PrendaDto> findPrendasTalle(String talle);

}
