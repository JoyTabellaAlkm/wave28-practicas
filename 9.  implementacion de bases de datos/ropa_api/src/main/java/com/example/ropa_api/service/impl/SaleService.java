package com.example.ropa_api.service.impl;

import com.example.ropa_api.dto.RequestSaleDto;
import com.example.ropa_api.dto.ResponseDto;
import com.example.ropa_api.model.Cloth;
import com.example.ropa_api.model.Sale;
import com.example.ropa_api.repository.ClothRepository;
import com.example.ropa_api.repository.SaleRepository;
import com.example.ropa_api.service.ISaleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SaleService implements ISaleService {
    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ClothRepository clothRepository;

    @Override
    public Sale create(RequestSaleDto requestSaleDto) {
        List<Cloth> cloths = clothRepository.findAllById(requestSaleDto.getClothesIds());

        if (cloths.size() != requestSaleDto.getClothesIds().size()) {
            throw new RuntimeException("No se encontraron todos los productos de la venta.");
        }

        ModelMapper modelMapper = new ModelMapper();
        Sale sale = modelMapper.map(requestSaleDto, Sale.class);
        sale.setClothes(cloths);
        return saleRepository.save(sale);
    }

    @Override
    public List<Sale> getAll() {
        return saleRepository.findAll();
    }

    @Override
    public Sale show(Long id) {
        return saleRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro la venta."));
    }

    @Override
    public Sale update(Long id, RequestSaleDto requestSaleDto) {
        ModelMapper modelMapper = new ModelMapper();
        saleRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro la venta."));
        List<Cloth> cloths = clothRepository.findAllById(requestSaleDto.getClothesIds());

        if (cloths.size() != requestSaleDto.getClothesIds().size()) {
            throw new RuntimeException("No se encontraron todos los productos de la venta.");
        }

        Sale sale = modelMapper.map(requestSaleDto, Sale.class);
        sale.setNumber(id);
        sale.setClothes(cloths);

        return saleRepository.save(sale);
    }

    @Override
    public ResponseDto delete(Long id) {
        saleRepository.findById(id).orElseThrow(() -> new RuntimeException("No se encontro la venta"));
        saleRepository.deleteById(id);
        return new ResponseDto("Se elimino la venta con ID: " + id);
    }

    @Override
    public List<Sale> getAllByDate(LocalDate date) {
        return saleRepository.findAllByDate(date);
    }
}
