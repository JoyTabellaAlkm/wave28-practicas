package com.bootcamp.showroom.service;

import com.bootcamp.showroom.dto.PrendaDTO;
import com.bootcamp.showroom.entity.Prenda;

import java.util.List;

public interface IPrendaService {

    List<PrendaDTO> getPrendas();

    List<PrendaDTO> getPrendaByCode(String codigo);

    List<PrendaDTO> getPrendaBySize(String talle);
    List<PrendaDTO> getPrendaByName(String nombre);

}
