package com.mercadolibre.ejercicioextrashowroom.service;

import com.mercadolibre.ejercicioextrashowroom.dto.request.CreateSaleDTO;
import com.mercadolibre.ejercicioextrashowroom.dto.response.ClothesDTO;
import com.mercadolibre.ejercicioextrashowroom.dto.response.MessageDTO;
import com.mercadolibre.ejercicioextrashowroom.dto.response.SaleDTO;
import java.time.LocalDate;
import java.util.List;

public interface ISaleService {

    MessageDTO createSale(CreateSaleDTO saleDTO);

    List<SaleDTO> getAllSales();

    SaleDTO getSaleById(Long id);

    MessageDTO deleteSale(Long id);

    List<SaleDTO> getSalesByDate(LocalDate date);

    List<ClothesDTO> getClothesBySale(Long id);

}
