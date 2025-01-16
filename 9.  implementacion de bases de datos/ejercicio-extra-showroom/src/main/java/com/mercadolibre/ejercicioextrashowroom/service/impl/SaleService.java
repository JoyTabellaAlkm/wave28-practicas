package com.mercadolibre.ejercicioextrashowroom.service.impl;

import com.mercadolibre.ejercicioextrashowroom.dto.request.CreateSaleDTO;
import com.mercadolibre.ejercicioextrashowroom.dto.response.ClothesDTO;
import com.mercadolibre.ejercicioextrashowroom.dto.response.MessageDTO;
import com.mercadolibre.ejercicioextrashowroom.dto.response.SaleDTO;
import com.mercadolibre.ejercicioextrashowroom.entity.Clothes;
import com.mercadolibre.ejercicioextrashowroom.entity.Sale;
import com.mercadolibre.ejercicioextrashowroom.exception.NotFoundException;
import com.mercadolibre.ejercicioextrashowroom.repository.ISaleRepository;
import com.mercadolibre.ejercicioextrashowroom.service.ISaleService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Service
public class SaleService implements ISaleService {

    ISaleRepository saleRepository;

    ModelMapper modelMapper = new ModelMapper();


    public SaleService(ISaleRepository saleRepository) {
        this.saleRepository = saleRepository;
    }

    @Override
    public MessageDTO createSale(CreateSaleDTO saleDTO) {
        Sale sale = modelMapper.map(saleDTO, Sale.class);
        sale.setDate(LocalDate.now());
        sale.calculateTotal();
        saleRepository.save(sale);
        return new MessageDTO("Venta creada correctamente.");
    }

    @Override
    public List<SaleDTO> getAllSales() {
        List<Sale> sales = saleRepository.findAll();
        return mapSalesListToDTOList(sales);
    }

    @Override
    public SaleDTO getSaleById(Long id) {
        Sale sale = findSaleById(id);
        return modelMapper.map(sale, SaleDTO.class);
    }

    @Override
    public MessageDTO deleteSale(Long id) {
        saleRepository.deleteById(id);
        return new MessageDTO("Venta eliminada correctamente.");
    }

    @Override
    public List<SaleDTO> getSalesByDate(LocalDate date) {
        List<Sale> sales = saleRepository.findSalesByDate(date);
        return mapSalesListToDTOList(sales);
    }

    @Override
    public List<ClothesDTO> getClothesBySale(Long id) {
        Sale sale = findSaleById(id);
        Set<Clothes> clothes = sale.getItems();
        return clothes
                .stream()
                .map(c -> modelMapper.map(c, ClothesDTO.class))
                .toList();
    }

    private List<SaleDTO> mapSalesListToDTOList(List<Sale> sales) {
        return sales
                .stream()
                .map(s -> modelMapper.map(s, SaleDTO.class))
                .toList();
    }

    private Sale findSaleById(Long id) {
        return saleRepository.findById(id)
                .orElseThrow(
                        () -> new NotFoundException("No se ha encontrado la venta solicitada.")
                );
    }



}
