package com.ar.mercadolibre.showroom.service;

import com.ar.mercadolibre.showroom.dto.ClotheDTO;
import com.ar.mercadolibre.showroom.dto.SaleDTO;
import com.ar.mercadolibre.showroom.entity.Clothe;
import com.ar.mercadolibre.showroom.entity.Sale;
import com.ar.mercadolibre.showroom.exceptions.NotFoundException;
import com.ar.mercadolibre.showroom.repository.ISaleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class SaleServiceImpl implements ISaleService{

    private final ISaleRepository saleRepository;
    private final ModelMapper mapper;

    public SaleServiceImpl(ISaleRepository saleRepository, ModelMapper mapper) {
        this.saleRepository = saleRepository;
        this.mapper = mapper;
    }

    @Override
    public SaleDTO create(SaleDTO saleDTO) {
        Sale saleToCreate = mapper.map(saleDTO, Sale.class);
        saleToCreate.setFecha(LocalDate.now());
        saleToCreate.setTotal(calculateTotal(saleToCreate.getListaDePrendas()));

        if (saleToCreate.getListaDePrendas() != null) {
            for (Clothe clothe : saleToCreate.getListaDePrendas()) {
                clothe.setSale(saleToCreate);
            }
        }
        Sale saleCreated = saleRepository.save(saleToCreate);

        return mapper.map(saleCreated, SaleDTO.class);
    }

    @Override
    public List<SaleDTO> getSales(LocalDate date) {
        List<Sale> sales;
        if(date == null) {
            sales = saleRepository.findAll();
        }
        else {
            sales = saleRepository.findByFecha(date);
        }
        if(sales.isEmpty()) {
            throw new NotFoundException("No se encontraron ventas");
        }
        return sales.stream().map(sale -> mapper.map(sale, SaleDTO.class)).toList();
    }

    @Override
    public SaleDTO getById(Long numero) {
        return mapper.map(validateSaleId(numero), SaleDTO.class);
    }

    @Override
    public SaleDTO update(Long number, SaleDTO saleDTO) {
        validateSaleId(number);
        Sale saleToUpdate = mapper.map(saleDTO, Sale.class);
        Sale updtaedSale = saleRepository.save(saleToUpdate);

        return mapper.map(updtaedSale, SaleDTO.class);
    }

    @Override
    public void delete(Long number) {
        Sale saleToDelete = validateSaleId(number);

        saleRepository.delete(saleToDelete);
    }

    @Override
    public List<SaleDTO> getByClothesNumber(Integer number) {
        List<Sale> sales = saleRepository.findSalesByNumberOfClothes(number);
        if(sales.isEmpty()) {
            throw new NotFoundException("No se encontraron ventas con ese numero de prendas");
        }
        return sales.stream().map(sale -> mapper.map(sale, SaleDTO.class)).toList();
    }

    private double calculateTotal(List<Clothe> clothes) {
        return clothes.stream().mapToDouble(Clothe::getPrecioVenta).sum();
    }

    private Sale validateSaleId(Long numero) {
        Optional<Sale> sale = saleRepository.findById(numero);
        if(sale.isEmpty()) {
            throw new NotFoundException("No se ha encontrado ninguna venta con ese numero");
        }

        return sale.get();
    }
}
