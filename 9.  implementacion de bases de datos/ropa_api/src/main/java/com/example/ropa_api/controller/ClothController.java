package com.example.ropa_api.controller;

import com.example.ropa_api.dto.RequestClothDto;
import com.example.ropa_api.service.impl.ClothService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/clothes")
public class ClothController {
    @Autowired
    private ClothService clothService;

    @PostMapping("new")
    public ResponseEntity<?> create(@RequestBody RequestClothDto requestTestCaseDto){
        return new ResponseEntity<>(clothService.create(requestTestCaseDto), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> index(@RequestParam Optional<String> name){
        return name.map(s -> new ResponseEntity<>(clothService.getAllByName(s), HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(clothService.getAll(), HttpStatus.OK));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> show(@PathVariable Long id){
        return new ResponseEntity<>(clothService.show(id), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody RequestClothDto requestTestCaseDto){
        return new ResponseEntity<>(clothService.update(id, requestTestCaseDto), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return new ResponseEntity<>(clothService.delete(id), HttpStatus.OK);
    }

    @GetMapping("size/{size}")
    public ResponseEntity<?> indexBySize(@PathVariable String size ){
        return new ResponseEntity<>(clothService.getAllBySize(size), HttpStatus.OK);
    }
}
