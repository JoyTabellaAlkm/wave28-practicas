package com.mercadolibre.clavecompuesta.service.impl;

import com.mercadolibre.clavecompuesta.dto.CompraDto;
import com.mercadolibre.clavecompuesta.model.Compra;
import com.mercadolibre.clavecompuesta.repository.ICompraRepository;
import com.mercadolibre.clavecompuesta.service.ICompraService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CompraService implements ICompraService {
    @Autowired
    ICompraRepository compraRepository;
    private final ModelMapper modelMapper = new ModelMapper();
    @Override
    public List<CompraDto> obtenerCompras() {
        return compraRepository.findAll().
                stream().map(compra->modelMapper.map(compra,CompraDto.class))
                .toList();
    }

    @Override
    public void nuevaCompra(CompraDto compraDto) {
        compraRepository.save(modelMapper.map(compraDto, Compra.class));
    }
}
