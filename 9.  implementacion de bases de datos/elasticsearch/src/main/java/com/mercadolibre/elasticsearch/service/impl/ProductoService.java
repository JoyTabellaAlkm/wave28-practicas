package com.mercadolibre.elasticsearch.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercadolibre.elasticsearch.dto.CreateProductoDto;
import com.mercadolibre.elasticsearch.entity.Producto;
import com.mercadolibre.elasticsearch.repository.IProductoRepository;
import com.mercadolibre.elasticsearch.service.IProductoService;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository productoRepository;

    private ModelMapper modelMapper = new ModelMapper();

    @Override
    public Producto save(CreateProductoDto producto) {
        return productoRepository.save(modelMapper.map(producto, Producto.class));
    }

    @Override
    public Iterable<Producto> findAll() {
        return productoRepository.findAll();
    }

}
