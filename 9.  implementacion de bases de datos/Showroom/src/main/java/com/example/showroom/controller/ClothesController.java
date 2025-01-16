package com.example.showroom.controller;

import com.example.showroom.dto.request.ClothesDTO;
import com.example.showroom.dto.response.ClothesDTOResponse;
import com.example.showroom.dto.response.MessageDTO;
import com.example.showroom.dto.response.UpdateClothesDTO;
import com.example.showroom.service.IClothesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clothes")
public class ClothesController {

    @Autowired
    private IClothesService clothesService;

    @PostMapping
    public ResponseEntity<MessageDTO> createClothes(@RequestBody ClothesDTO clothesDTO){
        return new ResponseEntity<>( clothesService.create(clothesDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ClothesDTOResponse>> getAll(){
        return new ResponseEntity<>( clothesService.getAll(), HttpStatus.OK);
    }


    @GetMapping("/size/{size}")
    public ResponseEntity<List<ClothesDTOResponse>> getAllBySize(@PathVariable String size){
        return new ResponseEntity<>( clothesService.getAllClothesBySize(size), HttpStatus.OK);
    }

    @GetMapping("/{code}")
    public ResponseEntity<ClothesDTOResponse> getAllBySize(@PathVariable Long code){
        return new ResponseEntity<>( clothesService.getClothesById(code), HttpStatus.OK);
    }

    @GetMapping("/name")
    public ResponseEntity<List<ClothesDTOResponse>> getAllByName(@RequestParam String name){
        return new ResponseEntity<>( clothesService.getAllClothesByName(name), HttpStatus.OK);
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<MessageDTO> deleteById(@PathVariable Long code){
        return new ResponseEntity<>( clothesService.deleteClothesById(code), HttpStatus.OK);
    }

    @PutMapping("/{code}")
    public ResponseEntity<UpdateClothesDTO> deleteById(@PathVariable Long code, @RequestBody ClothesDTO clothesDTO){
        return new ResponseEntity<>( clothesService.updateClothesById(code, clothesDTO), HttpStatus.OK);
    }

}
