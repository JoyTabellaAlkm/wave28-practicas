package com.mercadolibre.showroom.service;

import com.mercadolibre.showroom.dto.ClothingDTO;
import com.mercadolibre.showroom.dto.requests.SaleRequestDTO;
import com.mercadolibre.showroom.dto.responses.MessageDTO;
import com.mercadolibre.showroom.dto.responses.SaleResponseDTO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface ISaleService {
    List<SaleResponseDTO> getSales();
    MessageDTO createSale(BigDecimal total, String paymentMethod, Map<Long, Integer> clothingQuantities);
    SaleResponseDTO findSaleByNumber(Long number);
    MessageDTO updateSale(Long number, BigDecimal total, String paymentMethod, Map<Long, Integer> clothingQuantities);
    MessageDTO deleteSale(Long number);
    List<SaleRequestDTO> findSaleByDate(LocalDate date);
}
