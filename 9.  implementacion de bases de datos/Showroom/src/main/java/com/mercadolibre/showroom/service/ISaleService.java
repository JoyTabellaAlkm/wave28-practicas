package com.mercadolibre.showroom.service;

import com.mercadolibre.showroom.dto.SaleDTO;
import com.mercadolibre.showroom.dto.responses.MessageDTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface ISaleService {
    List<SaleDTO> getSales();
    MessageDTO createSale(BigDecimal total, String paymentMethod, Map<Long, Integer> clothingQuantities);
    SaleDTO findSaleByNumber(Long number);
    MessageDTO updateSale(Long number, BigDecimal total, String paymentMethod, Map<Long, Integer> clothingQuantities);
    MessageDTO deleteSale(Long number);
    SaleDTO findSaleByDate(LocalDate date);
}
