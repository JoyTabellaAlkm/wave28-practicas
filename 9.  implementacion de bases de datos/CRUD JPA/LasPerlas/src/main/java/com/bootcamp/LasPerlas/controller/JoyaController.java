package com.bootcamp.LasPerlas.controller;

import com.bootcamp.LasPerlas.dto.JewelryListResponse;
import com.bootcamp.LasPerlas.dto.JewelResponse;
import com.bootcamp.LasPerlas.model.Joya;
import com.bootcamp.LasPerlas.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class JoyaController {

    @Autowired
    IJoyaService joyaServ;

    @PostMapping ("/jewerly/new")
    public ResponseEntity<JewelResponse> saveJoya (@RequestBody Joya joya) {
        return new ResponseEntity<>(joyaServ.saveJoya(joya), HttpStatus.CREATED);
    }

    @GetMapping ("/jewerly")
    public ResponseEntity<JewelryListResponse> getJoyas () {
        return new ResponseEntity<>(joyaServ.getJoyas(), HttpStatus.OK);
    }

    //como es un borrado lógico, se trata más bien de un update y no de un delete
    //por eso usamos put
    @PutMapping ("/jewerly/delete/{id}")
    public ResponseEntity<JewelResponse> deleteJoya (@PathVariable Long id) {
        return new ResponseEntity<>(joyaServ.deleteJoya(id), HttpStatus.OK);
    }

    @PutMapping ("/jewerly/update/{id_modificar}")
    public ResponseEntity<JewelResponse> editJoya (@PathVariable Long id_modificar,
                            @RequestBody Joya joya) {

        return new ResponseEntity<>(joyaServ.editJoya(id_modificar, joya), HttpStatus.OK);
    }


}
