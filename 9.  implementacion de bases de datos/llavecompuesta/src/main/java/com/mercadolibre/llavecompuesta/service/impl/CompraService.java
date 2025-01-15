package com.mercadolibre.llavecompuesta.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolibre.llavecompuesta.dto.CompraDto;
import com.mercadolibre.llavecompuesta.dto.CreateCompraDto;
import com.mercadolibre.llavecompuesta.entity.Compra;
import com.mercadolibre.llavecompuesta.repository.ICompraRepository;
import com.mercadolibre.llavecompuesta.service.ICompraService;

@Service
public class CompraService implements ICompraService {

    @Autowired
    private ICompraRepository compraRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public CompraDto save(CreateCompraDto request) {
        Compra toSave = modelMapper.map(request, Compra.class);
        toSave.setFecha(LocalDateTime.now());

        Compra saved = compraRepository.save(toSave);
        return modelMapper.map(saved, CompraDto.class);
    }

    @Override
    public List<CompraDto> findAll() {
        return compraRepository.findAll()
                .stream()
                .map(c -> modelMapper.map(c, CompraDto.class))
                .toList();
    }

}
