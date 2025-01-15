package com.bootcamp.LasPerlas.controller;

import com.bootcamp.LasPerlas.dto.JoyaDto;
import com.bootcamp.LasPerlas.dto.MensajeDto;
import com.bootcamp.LasPerlas.model.Joya;
import com.bootcamp.LasPerlas.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
public class JoyaController {

    @Autowired
    IJoyaService joyaServ;

    @PostMapping ("/jewerly/new")
    public ResponseEntity<MensajeDto> saveJoya (@RequestBody JoyaDto joya) {
        return new ResponseEntity(joyaServ.saveJoya(joya), HttpStatus.CREATED);
    }

    @GetMapping ("/jewerly")
    public ResponseEntity<List<JoyaDto> >getJoyas () {

        return new ResponseEntity<>(joyaServ.getJoyas(), HttpStatus.OK);
    }

    //como es un borrado lógico, se trata más bien de un update y no de un delete
    //por eso usamos put
    @PutMapping ("/jewerly/delete/{id}")
    public ResponseEntity<MensajeDto> deleteJoya (@PathVariable Long id) {
        return new ResponseEntity(joyaServ.deleteJoya(id), HttpStatus.OK);
    }

    @PutMapping ("/jewerly/update/{id_modificar}")
    public ResponseEntity<MensajeDto> editJoya (@PathVariable Long id_modificar,
                            @RequestBody JoyaDto joya) {

        return  new ResponseEntity(joyaServ.editJoya(id_modificar, joya),HttpStatus.OK);
    }


}
