package com.ar.mercadolibre.showroom.service;

import com.ar.mercadolibre.showroom.dto.ClotheDTO;
import com.ar.mercadolibre.showroom.dto.SaleDTO;

import java.time.LocalDate;
import java.util.List;

public interface ISaleService {
    SaleDTO create(SaleDTO saleDTO);
    List<SaleDTO> getSales(LocalDate date);
    SaleDTO getById(Long numero);
    SaleDTO update(Long number, SaleDTO saleDTO);
    void delete(Long number);
    List<SaleDTO> getByClothesNumber(Integer number);
}
