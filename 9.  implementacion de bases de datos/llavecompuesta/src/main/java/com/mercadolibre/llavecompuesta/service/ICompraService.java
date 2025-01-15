package com.mercadolibre.llavecompuesta.service;

import java.util.List;

import com.mercadolibre.llavecompuesta.dto.CompraDto;
import com.mercadolibre.llavecompuesta.dto.CreateCompraDto;

public interface ICompraService {

    public CompraDto save(CreateCompraDto request);
    public List<CompraDto> findAll();

}
