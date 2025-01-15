package com.mercadolibre.showroom.service;

import com.mercadolibre.showroom.dto.SaleDTO;

import java.util.List;

public interface ISaleService {
    SaleDTO create(SaleDTO sale);
    List<SaleDTO> findAll();
    SaleDTO findSaleByNumber(Integer number);

    SaleDTO update(Integer number, SaleDTO saleDTO);

    SaleDTO delete(Integer number);
}
