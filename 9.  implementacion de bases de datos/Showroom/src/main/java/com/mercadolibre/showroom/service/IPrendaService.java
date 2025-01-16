package com.mercadolibre.showroom.service;

import com.mercadolibre.showroom.dto.PrendaDto;

import java.util.List;

public interface IPrendaService {

    Boolean createPrenda(PrendaDto prendaDto);
    List<PrendaDto> getPrendas();
    PrendaDto getPrendaByCode(Long code);
    Boolean updatePrenda(Long code, PrendaDto prendaDto);
    Boolean deletePrenda(Long code);
    List<PrendaDto> getPrendasBySize(String size);
    List<PrendaDto> getPrendasByName(String name);
}
