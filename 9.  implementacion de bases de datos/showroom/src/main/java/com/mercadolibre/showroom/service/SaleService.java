package com.mercadolibre.showroom.service;

import com.mercadolibre.showroom.dto.ClotheDTO;
import com.mercadolibre.showroom.dto.SaleDTO;
import com.mercadolibre.showroom.entity.Clothe;
import com.mercadolibre.showroom.entity.Sale;
import com.mercadolibre.showroom.exception.NotFoundException;
import com.mercadolibre.showroom.repository.ISaleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaleService implements ISaleService{

    @Autowired
    private ISaleRepository saleRepository;

    @Autowired
    private ClotheService clotheService;

    ModelMapper modelMapper = new ModelMapper();

    @Override
    public SaleDTO create(SaleDTO saleDTO) {

        List<Clothe> clothes = saleDTO.getClothes()
                .stream()
                .map(c -> this.clotheService.findById(c)).
                toList();

        Sale sale = modelMapper.map(saleDTO, Sale.class);
        sale.setClothes(clothes);

        Sale newSale = this.saleRepository.save(sale);

        return modelMapper.map(newSale, SaleDTO.class);

    }

    @Override
    public List<SaleDTO> findAll() {
        List<Sale> sales = this.saleRepository.findAll();
        return sales.stream().map(sale -> modelMapper.map(sale, SaleDTO.class)).toList();
    }

    @Override
    public SaleDTO findSaleByNumber(Integer number) {
        Sale sale = this.saleRepository.findSaleByNumber(number);
        if(sale == null) throw new NotFoundException("No se encontró ninguna venta con el numero: " + number);

        return modelMapper.map(sale,SaleDTO.class);
    }

    @Override
    public SaleDTO update(Integer number, SaleDTO saleDTO) {
        SaleDTO sale = findSaleByNumber(number);
        saleDTO.setId(sale.getId());

        List<Clothe> clothes = saleDTO.getClothes()
                .stream()
                .map(c -> this.clotheService.findById(c)).
                toList();

        Sale updatedSale = modelMapper.map(saleDTO, Sale.class);
        updatedSale.setClothes(clothes);

        Sale newSale = this.saleRepository.save(updatedSale);

        return modelMapper.map(newSale, SaleDTO.class);
    }

    @Override
    public SaleDTO delete(Integer number) {
        SaleDTO saleDTO = findSaleByNumber(number);
        Sale sale = modelMapper.map(saleDTO, Sale.class);
        this.saleRepository.delete(sale);
        return saleDTO;
    }
}
