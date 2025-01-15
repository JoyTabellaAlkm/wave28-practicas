package com.bootcamp.clothes.service;

import com.bootcamp.clothes.dto.SaleDTO;
import com.bootcamp.clothes.entity.Clothe;
import com.bootcamp.clothes.repository.IClotheRepository;
import com.bootcamp.clothes.repository.ISaleRepository;
import org.springframework.stereotype.Service;
import com.bootcamp.clothes.entity.Sale;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class SaleService {
    private final ISaleRepository saleRepository;
    private final IClotheRepository clotheRepository;

    public SaleService(ISaleRepository saleRepository, IClotheRepository clotheRepository) {
        this.saleRepository = saleRepository;
        this.clotheRepository = clotheRepository;
    }

    public Sale createSale(SaleDTO saleDTO) {
        Sale sale = mapSaleDTOToSale(saleDTO);

        return saleRepository.save(sale);
    }

    private Sale mapSaleDTOToSale(SaleDTO saleDTO) {
        Set<Clothe> clothes = clotheRepository.findAllByCodeIn(saleDTO.getClothesIds());
        Sale sale = new Sale();
        sale.setDate(saleDTO.getDate());
        sale.setTotal(saleDTO.getTotal());
        sale.setPaymentMethod(saleDTO.getPaymentMethod());
        sale.setClothes(clothes);
        return sale;
    }

    public List<Sale> getAllSales() {
        return saleRepository.findAll();
    }

    public Sale getSaleByNumber(Long number) {
        return saleRepository.findById(number).orElse(null);
    }

    public Sale updateSale(Long number, SaleDTO updatedSale) {
        Sale saleToUpdate = mapSaleDTOToSale(updatedSale);

        Sale existingSale = saleRepository.findById(number).orElse(null);

        if (existingSale != null) {
            existingSale.setDate(saleToUpdate.getDate());
            existingSale.setTotal(saleToUpdate.getTotal());
            existingSale.setPaymentMethod(saleToUpdate.getPaymentMethod());
            existingSale.setClothes(saleToUpdate.getClothes());
            return saleRepository.save(existingSale);
        }

        return null;
    }

    public boolean deleteSale(Long number) {
        Sale existingSale = saleRepository.findById(number).orElse(null);
        if (existingSale != null) {
            saleRepository.delete(existingSale);
            return true;
        }
        return false;
    }

    public Set<Clothe> getClothesBySaleDate(LocalDate date) {
        List<Sale> sales = saleRepository.findAllByDate(date);
        Set<Clothe> clothesSet = new HashSet<>();

        for (Sale sale : sales) {
            clothesSet.addAll(sale.getClothes());
        }

        return clothesSet;
    }
}
