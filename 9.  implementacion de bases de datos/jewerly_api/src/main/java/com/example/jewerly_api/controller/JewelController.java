package com.example.jewerly_api.controller;

import com.example.jewerly_api.dto.request.RequestJewelDto;
import com.example.jewerly_api.service.impl.JewelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("jewerly")
public class JewelController {
    @Autowired
    private JewelService jewelService;

    @PostMapping("new")
    public ResponseEntity<?> create(@Valid @RequestBody RequestJewelDto requestPostDto){
        return new ResponseEntity<>(jewelService.create(requestPostDto), HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<?> index(){
        return new ResponseEntity<>(jewelService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        return new ResponseEntity<>(jewelService.delete(id), HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @Valid @RequestBody RequestJewelDto requestJewelDto){
        return new ResponseEntity<>(jewelService.update(id, requestJewelDto), HttpStatus.OK);
    }
}
