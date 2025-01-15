package com.mercadolibre.showroom.service;

import com.mercadolibre.showroom.dto.PrendaDto;

import java.util.List;
import java.util.Optional;

public interface IPrendaService {
    Integer crearNuevaPrenda(PrendaDto prendaDto);
    List<PrendaDto> obtenerPrendas();
    PrendaDto obtenerPrenda(Integer codigo);
    PrendaDto actualizarPrenda(Integer codigo, PrendaDto prendaDto);
    void eliminarPrenda(Integer codigo);
    List<PrendaDto> buscarPrendasXTalle(String talle);
    List<PrendaDto> buscarPrendasXNombre(String nombre);
}
