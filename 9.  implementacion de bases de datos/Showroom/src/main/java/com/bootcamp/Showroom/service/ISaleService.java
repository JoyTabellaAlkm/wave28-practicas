package com.bootcamp.Showroom.service;

import com.bootcamp.Showroom.dto.ClothDto;
import com.bootcamp.Showroom.dto.SaleDto;

import java.time.LocalDate;
import java.util.List;

public interface ISaleService {
    void create(SaleDto dto);
    List<SaleDto> getAllSales();
    SaleDto getSaleByNumber(Integer number);
    void updateSale(Integer number, SaleDto dto);
    void deleteSale(Integer number);
    List<SaleDto> getSalesByDate(LocalDate date);
    List<ClothDto> getClothesBySaleNumber(Integer number);
}
