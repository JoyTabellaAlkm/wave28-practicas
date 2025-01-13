package com.mercadolibre.clavecompuesta.service;

import com.mercadolibre.clavecompuesta.dto.CompraDto;

import java.util.List;

public interface ICompraService {
    List<CompraDto> obtenerCompras();
    void nuevaCompra(CompraDto compraDto);
}
