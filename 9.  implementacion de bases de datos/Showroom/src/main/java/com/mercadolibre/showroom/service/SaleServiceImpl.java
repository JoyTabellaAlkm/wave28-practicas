package com.mercadolibre.showroom.service;

import com.mercadolibre.showroom.dto.ClothingDTO;
import com.mercadolibre.showroom.dto.requests.SaleRequestDTO;
import com.mercadolibre.showroom.dto.responses.MessageDTO;
import com.mercadolibre.showroom.dto.responses.SaleClothingDTO;
import com.mercadolibre.showroom.dto.responses.SaleResponseDTO;
import com.mercadolibre.showroom.exception.BadRequestException;
import com.mercadolibre.showroom.exception.NotFoundException;
import com.mercadolibre.showroom.model.Clothing;
import com.mercadolibre.showroom.model.Sale;
import com.mercadolibre.showroom.model.SaleClothing;
import com.mercadolibre.showroom.repository.IClothingRepository;
import com.mercadolibre.showroom.repository.ISaleClothingRepository;
import com.mercadolibre.showroom.repository.ISaleRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SaleServiceImpl implements ISaleService {

    private final ISaleRepository saleRepository;
    private final IClothingRepository clothingRepository;
    private final ISaleClothingRepository saleClothingRepository;
    private final ModelMapper modelMapper = new ModelMapper();

    public SaleServiceImpl(ISaleRepository saleRepository, IClothingRepository clothingRepository, ISaleClothingRepository saleClothingRepository) {
        this.clothingRepository = clothingRepository;
        this.saleRepository = saleRepository;
        this.saleClothingRepository = saleClothingRepository;
    }

    @Override
    public List<SaleResponseDTO> getSales() {
        List<Sale> sales = saleRepository.findAllWithClothings();

        return sales.stream()
                .map(this::mapToSaleResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public MessageDTO createSale(BigDecimal total, String paymentMethod, Map<Long, Integer> clothingQuantities) {
        Sale sale = new Sale();
        sale.setDate(LocalDate.now());
        sale.setTotal(total);
        sale.setPaymentMethod(paymentMethod);

        BigDecimal computedTotal = BigDecimal.ZERO;

        for (Map.Entry<Long, Integer> entry : clothingQuantities.entrySet()) {
            Long clothingCode = entry.getKey();
            Integer quantity = entry.getValue();

            Optional<Clothing> clothingOpt = clothingRepository.findById(clothingCode);
            if (clothingOpt.isPresent()) {
                Clothing clothing = clothingOpt.get();

                if (clothing.getStock() < quantity) {
                    throw new RuntimeException("Stock insuficiente para el código de clothing " + clothingCode);
                }

                clothing.setStock(clothing.getStock() - quantity);
                clothingRepository.save(clothing);

                SaleClothing saleClothing = new SaleClothing();
                saleClothing.setSale(sale);
                saleClothing.setClothing(clothing);
                saleClothing.setQuantity(quantity);

                sale.getSaleClothings().add(saleClothing);

                // Supongamos que cada `Clothing` tiene un precio
                BigDecimal itemTotal = clothing.getPrice().multiply(new BigDecimal(quantity));
                computedTotal = computedTotal.add(itemTotal);
            } else {
                throw new RuntimeException("Clothing con código " + clothingCode + " no encontrado.");
            }
        }

        // Comparar el total pasado con el total calculado
        if (total.compareTo(computedTotal) != 0) {
            throw new BadRequestException("Total price does not match.");
        }

        sale.setTotal(computedTotal);
        saleRepository.save(sale);

        return new MessageDTO("Sale created successfully.");
    }

    @Override
    public SaleResponseDTO findSaleByNumber(Long number) {
        Sale sale = saleRepository.findByNumberWithClothings(number)
                .orElseThrow(() -> new NotFoundException("Venta con número " + number + " no encontrada"));

        return mapToSaleResponseDTO(sale);
    }

    @Override
    @Transactional
    public MessageDTO updateSale(Long number, BigDecimal total, String paymentMethod, Map<Long, Integer> clothingQuantities) {

        Sale sale = saleRepository.findById(number)
                .orElseThrow(() -> new NotFoundException("Sale with number " + number + " not found."));

        sale.setTotal(total);
        sale.setPaymentMethod(paymentMethod);

        // Obtener todas las SaleClothings actuales de la venta
        List<SaleClothing> existingSaleClothings = saleClothingRepository.findBySaleNumber(number);

        // Map para acceso rápido a las SaleClothings existentes
        Map<Long, SaleClothing> existingMap = existingSaleClothings.stream()
                .collect(Collectors.toMap(sc -> sc.getClothing().getCode(), sc -> sc));

        // Revertir el stock basado en las SaleClothings existentes
        for (SaleClothing sc : existingSaleClothings) {
            Clothing clothing = sc.getClothing();
            clothing.setStock(clothing.getStock() + sc.getQuantity());
            clothingRepository.save(clothing);
        }

        // Limpiar las SaleClothings actuales
        saleClothingRepository.deleteAll(existingSaleClothings);

        // Reiniciar lista
        List<SaleClothing> updatedSaleClothings = new ArrayList<>();
        BigDecimal computedTotal = BigDecimal.ZERO;

        for (Map.Entry<Long, Integer> entry : clothingQuantities.entrySet()) {
            Long clothingCode = entry.getKey();
            Integer quantity = entry.getValue();

            Clothing clothing = clothingRepository.findById(clothingCode)
                    .orElseThrow(() -> new NotFoundException("Clothing with code " + clothingCode + " not found."));

            if (clothing.getStock() < quantity) {
                throw new BadRequestException("Stock insuficiente para el código de clothing " + clothingCode);
            }

            // Actualizar el stock
            clothing.setStock(clothing.getStock() - quantity);
            clothingRepository.save(clothing);

            // Crear o actualizar SaleClothing
            SaleClothing saleClothing = new SaleClothing();
            saleClothing.setSale(sale);
            saleClothing.setClothing(clothing);
            saleClothing.setQuantity(quantity);
            saleClothingRepository.save(saleClothing);

            // Calcular el total (asumiendo que Clothing tiene un campo `price`)
            computedTotal = computedTotal.add(clothing.getPrice().multiply(new BigDecimal(quantity)));
        }

        // Actualizar el total de la venta si es necesario
        sale.setTotal(computedTotal);
        saleRepository.save(sale);

        return new MessageDTO("Sale updated successfully.");
    }

    @Override
    public MessageDTO deleteSale(Long number) {
        saleRepository.deleteById(number);
        return new MessageDTO("Sale deleted successfully.");
    }

    @Override
    public List<SaleRequestDTO> findSaleByDate(LocalDate date) {
        System.out.println(date);
        return saleRepository.findByDate(date).stream()
                .map(sale -> new SaleRequestDTO(
                        sale.getTotal(),
                        sale.getPaymentMethod(),
                        sale.getSaleClothings().stream()
                                .collect(Collectors.toMap(saleClothing -> saleClothing.getClothing().getCode(), saleClothing -> saleClothing.getQuantity()))
                ))
                .toList();
    }

    private SaleResponseDTO mapToSaleResponseDTO(Sale sale) {
        List<SaleClothingDTO> clothingDTOs = sale.getSaleClothings().stream()
                .map(this::mapToSaleClothingDTO)
                .collect(Collectors.toList());

        return new SaleResponseDTO(
                sale.getTotal(),
                sale.getPaymentMethod(),
                clothingDTOs
        );
    }

    private SaleClothingDTO mapToSaleClothingDTO(SaleClothing saleClothing) {
        ClothingDTO clothingDTO = mapToClothingDTO(saleClothing.getClothing());

        return new SaleClothingDTO(
                saleClothing.getQuantity(),
                clothingDTO
        );
    }

    private ClothingDTO mapToClothingDTO(Clothing clothing) {
        return new ClothingDTO(
                clothing.getName(),
                clothing.getType(),
                clothing.getBrand(),
                clothing.getSize(),
                clothing.getColor(),
                clothing.getStock(),
                clothing.getPrice()
        );
    }
}
