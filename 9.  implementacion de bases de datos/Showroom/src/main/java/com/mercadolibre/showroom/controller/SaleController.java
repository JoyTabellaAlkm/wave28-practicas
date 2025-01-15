package com.mercadolibre.showroom.controller;

import com.mercadolibre.showroom.dto.SaleDTO;
import com.mercadolibre.showroom.dto.responses.MessageDTO;
import com.mercadolibre.showroom.service.ISaleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sale")
public class SaleController {

    private final ISaleService saleService;

    public SaleController(ISaleService saleService) {
        this.saleService = saleService;
    }

    // Obtener todas las ventas
    @GetMapping("")
    public ResponseEntity<List<SaleDTO>> getSales() {
        return ResponseEntity.ok(saleService.getSales());
    }

    // Crear una nueva venta
    @PostMapping("")
    public ResponseEntity<MessageDTO> saveSales(@RequestBody SaleDTO saleRequestDTO) {
        return ResponseEntity.ok(saleService.createSale(
                saleRequestDTO.getTotal(),
                saleRequestDTO.getPaymentMethod(),
                saleRequestDTO.getClothingQuantities()
        ));
    }

    // Buscar una venta por su número
    @GetMapping("/{number}")
    public ResponseEntity<SaleDTO> findSaleByNumber(@PathVariable Long number) {
        return ResponseEntity.ok(saleService.findSaleByNumber(number));
    }

    // Actualizar una venta
    @PutMapping("/{number}")
    public ResponseEntity<MessageDTO> updateSale(@PathVariable Long number, @RequestBody SaleDTO saleRequestDTO) {
        return ResponseEntity.ok(saleService.updateSale(
                number,
                saleRequestDTO.getTotal(),
                saleRequestDTO.getPaymentMethod(),
                saleRequestDTO.getClothingQuantities()
        ));
    }

    // Eliminar una venta
    @DeleteMapping("/{number}")
    public ResponseEntity<MessageDTO> deleteSale(@PathVariable Long number) {
        return ResponseEntity.ok(saleService.deleteSale(number));
    }



}
