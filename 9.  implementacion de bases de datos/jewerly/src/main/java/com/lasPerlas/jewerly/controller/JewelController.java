package com.lasPerlas.jewerly.controller;

import com.lasPerlas.jewerly.dto.request.NewJewelDTO;
import com.lasPerlas.jewerly.dto.response.JewelDTO;
import com.lasPerlas.jewerly.service.IJewelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JewelController {

    @Autowired
    IJewelService jewelService;

    @GetMapping
    public ResponseEntity<List<JewelDTO>> getAllJowels(){
        return new ResponseEntity<List<JewelDTO>>(jewelService.getAllJewels(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<JewelDTO> getById(@PathVariable Long id){
        return new ResponseEntity<JewelDTO>(jewelService.getById(id),HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Long> createJewel(@RequestBody NewJewelDTO newJewelDTO){
        return new ResponseEntity<Long>(jewelService.createJewel(newJewelDTO), HttpStatus.CREATED);
    }

    @PostMapping("/update/{id_modificar}")
    public ResponseEntity<JewelDTO> updateById(@RequestBody NewJewelDTO newJewelDTO, @PathVariable Long id_modificar){
        return new ResponseEntity<JewelDTO>(jewelService.update(newJewelDTO, id_modificar), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        return new ResponseEntity<>(jewelService.deleteById(id), HttpStatus.NO_CONTENT);
    }

}
