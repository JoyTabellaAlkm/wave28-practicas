package com.mercadolibre.social.controller;

import com.mercadolibre.social.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("/products"))
public class ProductController {

    private final IProductService productService;

    public ProductController(IProductService productService) {
        this.productService = productService;
    }

    @GetMapping("")
    public ResponseEntity<?> search(@RequestParam("search") String query, @RequestParam(value = "range_price", defaultValue = "") String rangePrice){
        return new ResponseEntity<>(productService.search(query, rangePrice), HttpStatus.OK);
    }

}
