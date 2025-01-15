package com.ar.mercadolibre.joyerialasperlas.controller;

import com.ar.mercadolibre.joyerialasperlas.dto.CreateMessageDTO;
import com.ar.mercadolibre.joyerialasperlas.dto.DeleteMessageDTO;
import com.ar.mercadolibre.joyerialasperlas.dto.JewelryDTO;
import com.ar.mercadolibre.joyerialasperlas.dto.UpdateMessageDTO;
import com.ar.mercadolibre.joyerialasperlas.service.IJewelryService;
import com.ar.mercadolibre.joyerialasperlas.service.JewelryServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/jewelry")
public class JewelryController {

    private final IJewelryService jewelryService;

    public JewelryController(IJewelryService jewelryService) {
        this.jewelryService = jewelryService;
    }

    @PostMapping("/new")
    public ResponseEntity<CreateMessageDTO> createJewelry(@RequestBody JewelryDTO jewelryDTO) {
        return new ResponseEntity<>(jewelryService.create(jewelryDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<JewelryDTO>> getAll() {
        return new ResponseEntity<>(jewelryService.getAll(), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<DeleteMessageDTO> delete(@PathVariable Long id) {
        return new ResponseEntity<>(jewelryService.delete(id), HttpStatus.OK);
    }

    @PutMapping("/update/{id_to_modify}")
    public ResponseEntity<UpdateMessageDTO> update(@PathVariable(name = "id_to_modify") Long idToModify, @RequestBody JewelryDTO jewelryDTO) {
        return new ResponseEntity<>(jewelryService.update(idToModify, jewelryDTO), HttpStatus.OK);
    }
}
