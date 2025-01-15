package org.bootcampmeli.ejercitacionextrasql.service;

import org.bootcampmeli.ejercitacionextrasql.dto.MessageDto;
import org.bootcampmeli.ejercitacionextrasql.dto.PrendaDto;

import java.util.List;

public interface IPrendaService {
    PrendaDto addPrenda(PrendaDto prendaDto);

    List<PrendaDto> getAllPrendas();

    PrendaDto getPrendaByCode(Long code);

    PrendaDto updatePrenda(Long codigo, PrendaDto prenda);

    MessageDto deletePrenda(Long codigo);

    List<PrendaDto> getBySize(String size);

    List<PrendaDto> getByName(String name);
}
