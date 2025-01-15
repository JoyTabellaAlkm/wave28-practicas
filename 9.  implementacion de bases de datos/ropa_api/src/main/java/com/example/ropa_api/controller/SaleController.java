package com.example.ropa_api.controller;

import com.example.ropa_api.dto.RequestSaleDto;
import com.example.ropa_api.service.impl.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("api/sales")
public class SaleController {
    @Autowired
    private SaleService clothService;

    @PostMapping("new")
    public ResponseEntity<?> create(@RequestBody RequestSaleDto requestTestCaseDto){
        return new ResponseEntity<>(clothService.create(requestTestCaseDto), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> index(@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Optional<LocalDate> date){
        return date.map(s -> new ResponseEntity<>(clothService.getAllByDate(s), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(clothService.getAll(), HttpStatus.OK));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> show(@PathVariable Long id){
        return new ResponseEntity<>(clothService.show(id), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody RequestSaleDto requestTestCaseDto){
        return new ResponseEntity<>(clothService.update(id, requestTestCaseDto), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return new ResponseEntity<>(clothService.delete(id), HttpStatus.OK);
    }
}
