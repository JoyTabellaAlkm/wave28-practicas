package com.mercadolibre.showroom.controller;

import com.mercadolibre.showroom.dto.requests.SaleRequestDTO;
import com.mercadolibre.showroom.dto.responses.MessageDTO;
import com.mercadolibre.showroom.dto.responses.SaleResponseDTO;
import com.mercadolibre.showroom.service.ISaleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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
    public ResponseEntity<List<SaleResponseDTO>> getSales() {
        return ResponseEntity.ok(saleService.getSales());
    }

    // Crear una nueva venta
    @PostMapping("")
    public ResponseEntity<MessageDTO> saveSales(@RequestBody SaleRequestDTO saleRequestDTO) {
        return ResponseEntity.ok(saleService.createSale(
                saleRequestDTO.getTotal(),
                saleRequestDTO.getPaymentMethod(),
                saleRequestDTO.getClothingQuantities()
        ));
    }

    // Buscar una venta por su número
    @GetMapping("/{number}")
    public ResponseEntity<SaleResponseDTO> findSaleByNumber(@PathVariable Long number) {
        return ResponseEntity.ok(saleService.findSaleByNumber(number));
    }

    // Actualizar una venta
    @PutMapping("/{number}")
    public ResponseEntity<MessageDTO> updateSale(@PathVariable Long number, @RequestBody SaleRequestDTO saleRequestDTO) {
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

    // Buscar venta por fecha con ?date=2020-01-01
    @GetMapping("/date")
    public ResponseEntity<List<SaleRequestDTO>> findSaleByDate(@RequestParam(name = "date") LocalDate date) {
        return ResponseEntity.ok(saleService.findSaleByDate(date));
    }

    @GetMapping("/api/sale/clothes/{number}")
    public ResponseEntity<SaleResponseDTO> findSaleByNumber2(@PathVariable Long number) {
        return ResponseEntity.ok(saleService.findSaleByNumber(number));
    }
}
