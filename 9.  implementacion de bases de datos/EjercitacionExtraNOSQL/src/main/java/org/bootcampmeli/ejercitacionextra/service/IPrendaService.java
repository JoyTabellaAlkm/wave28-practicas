package org.bootcampmeli.ejercitacionextra.service;

import org.bootcampmeli.ejercitacionextra.dto.MessageDto;
import org.bootcampmeli.ejercitacionextra.dto.PrendaDto;

import java.util.List;

public interface IPrendaService {
    PrendaDto addPrenda(PrendaDto prendaDto);

    List<PrendaDto> getAllPrendas();

    PrendaDto getPrendaByCode(String code);

    PrendaDto updatePrenda(String codigo, PrendaDto prenda);

    MessageDto deletePrenda(String codigo);

    List<PrendaDto> getBySize(String size);

    List<PrendaDto> getByName(String name);
}
