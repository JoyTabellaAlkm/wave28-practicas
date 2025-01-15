package com.meli.tienda.service;

import com.meli.tienda.dto.MessageDto;
import com.meli.tienda.dto.PrendaDto;
import com.meli.tienda.model.Prenda;

import java.util.List;

public interface IPrendaService {
    PrendaDto crearNuevaPrenda(PrendaDto prendaDto);
    List<PrendaDto> traerTodasPrendas();
    PrendaDto traerPrendaPorId(Long id);
    PrendaDto actualizarPorId(Long id, PrendaDto prendaDto);

    MessageDto eliminarPorId(Long id);

    List<PrendaDto> traerPrendaPorTalle(int size);

    List<PrendaDto> traerPrendasPorNombre(String nombre);
}
