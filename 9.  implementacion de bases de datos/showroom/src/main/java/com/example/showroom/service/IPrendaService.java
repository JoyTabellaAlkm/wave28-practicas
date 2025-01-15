package com.example.showroom.service;

import com.example.showroom.dto.MessageDto;
import com.example.showroom.dto.PrendaDto;
import com.example.showroom.dto.PrendaWithCodeDto;

import java.util.List;

public interface IPrendaService {
    PrendaWithCodeDto createPrenda(PrendaDto prendaDto);
    List<PrendaWithCodeDto> getAllPrendas();
    PrendaDto getPrendaByCodigo(Long codigo);
    PrendaDto updatePrenda(PrendaDto prendaDto, Long codigo);
    MessageDto deletePrenda(Long codigo);
    List<PrendaWithCodeDto> getPrendasByTalla(String talla);
    List<PrendaWithCodeDto> getPrendasByName(String name);
}
