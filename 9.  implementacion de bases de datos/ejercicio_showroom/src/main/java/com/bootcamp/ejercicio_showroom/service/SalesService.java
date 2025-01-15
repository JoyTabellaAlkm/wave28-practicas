package com.bootcamp.ejercicio_showroom.service;

import com.bootcamp.ejercicio_showroom.model.Clothes;
import com.bootcamp.ejercicio_showroom.model.SaleItems;
import com.bootcamp.ejercicio_showroom.model.Sales;
import com.bootcamp.ejercicio_showroom.repository.ClothesRepository;
import com.bootcamp.ejercicio_showroom.repository.SalesRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class SalesService {
    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private ClothesRepository clothesRepository;

    public Sales createSale(Sales sale) {
        double total = 0.0;
        for (var item : sale.getItems()) {
            Clothes clothes = clothesRepository.findById(item.getClothes().getId())
                    .orElseThrow(() -> new RuntimeException("Clothes not found for ID: " + item.getClothes().getId()));
            item.setClothes(clothes);
            total += item.getClothes().getPrice() * item.getQuantity();
        }
        sale.setTotal(total);
        return salesRepository.save(sale);
    }

    public List<Sales> getAllSales() {
        return salesRepository.findAll();
    }

    public Sales getSaleByNumber(Long number) {
        return salesRepository.findById(number).orElseThrow(() -> new RuntimeException("Sale not found"));
    }

    public Sales updateSale(Long number, Sales saleDetails) {
        Sales existingSale = salesRepository.findById(number).orElseThrow(() -> new RuntimeException("Sale not found"));
        existingSale.setDate(saleDetails.getDate());
        existingSale.setPaymentMethod(saleDetails.getPaymentMethod());
        double total = 0.0;
        for (var item : saleDetails.getItems()) {
            Clothes clothes = clothesRepository.findById(item.getClothes().getId())
                    .orElseThrow(() -> new RuntimeException("Clothes not found for ID: " + item.getClothes().getId()));
            item.setClothes(clothes);
            total += item.getClothes().getPrice() * item.getQuantity();
        }
        existingSale.setItems(saleDetails.getItems());
        existingSale.setTotal(total);
        return salesRepository.save(existingSale);
    }

    @Transactional
    public void deleteSale(Long number) {
        salesRepository.deleteById(number);
    }

    public List<Sales> getSalesByDate(LocalDate date) {
        return salesRepository.findByDate(date);
    }

    public List<Clothes> getClothesBySalesId(Long number) {
        Sales sales = salesRepository.findById(number).orElseThrow(() -> new RuntimeException(
                "Sale not found"));
        return sales.getItems().stream().map(SaleItems::getClothes).toList();
    }
}
