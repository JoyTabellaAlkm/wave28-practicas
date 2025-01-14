package com.mercadolibre.purchases.controller;

import com.mercadolibre.purchases.entity.Purchase;
import com.mercadolibre.purchases.service.PurchaseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/purchases")
public class PurchaseController {
    private final PurchaseService purchaseService;

    public PurchaseController(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @PostMapping
    public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
        return new ResponseEntity<>(purchaseService.save(purchase), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Purchase>> findAll() {
        return new ResponseEntity<>(purchaseService.findAll(), HttpStatus.OK);
    }
}
