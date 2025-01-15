package com.bootcamp.Showroom.service.impl;

import com.bootcamp.Showroom.dto.ClothDto;
import com.bootcamp.Showroom.dto.SaleDto;
import com.bootcamp.Showroom.entity.Cloth;
import com.bootcamp.Showroom.entity.Sale;
import com.bootcamp.Showroom.repository.ISaleRepository;
import com.bootcamp.Showroom.service.ISaleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SaleService implements ISaleService {

    private final ISaleRepository saleRepository;
    private final ModelMapper modelMapper = new ModelMapper();


    public SaleService(ISaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public void create(SaleDto dto) {
        Sale sale = new Sale();
        modelMapper.map(dto, sale);
        saleRepository.save(sale);
    }

    @Override
    public List<SaleDto> getAllSales() {
        return saleRepository.findAll().stream()
                .map(sale -> modelMapper.map(sale, SaleDto.class))
                .toList();
    }

    @Override
    public SaleDto getSaleByNumber(Integer number) {
        return modelMapper.map(saleRepository.findByNumber(number), SaleDto.class);
    }

    @Override
    public void updateSale(Integer number, SaleDto dto) {
        Sale sale = saleRepository.findByNumber(number);
        modelMapper.map(dto,sale);
        saleRepository.save(sale);
    }

    @Override
    public void deleteSale(Integer number) {
        saleRepository.deleteByNumber(number);
    }

    @Override
    public List<SaleDto> getSalesByDate(LocalDate date) {
        return saleRepository.findSalesByDate(date).stream()
                .map(sale -> modelMapper.map(sale,SaleDto.class))
                .toList();
    }

    @Override
    public List<ClothDto> getClothesBySaleNumber(Integer number) {
        return saleRepository.findClothesBySaleNumber(number).stream()
                .map(cloth -> modelMapper.map(cloth, ClothDto.class))
                .toList();
    }
}
