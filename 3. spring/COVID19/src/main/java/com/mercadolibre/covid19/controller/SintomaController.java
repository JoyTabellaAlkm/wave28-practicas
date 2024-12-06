package com.mercadolibre.covid19.controller;

import com.mercadolibre.covid19.dto.SintomaDTO;
import com.mercadolibre.covid19.service.ISintomaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SintomaController {
    @Autowired
    ISintomaService sintomaService;

    @GetMapping("/buscarSintomas")
    public ResponseEntity<List<SintomaDTO>> devolverSintomas(){
        return new ResponseEntity<>(sintomaService.buscarSintomas(), HttpStatus.OK);
    }

    @GetMapping("/buscarSintoma/{nombreSintoma}")
    public ResponseEntity<SintomaDTO> devolverSintomaPorNombre(@PathVariable String nombreSintoma){
        return new ResponseEntity<>(sintomaService.buscarSintomaPorNombre(nombreSintoma),HttpStatus.OK);
    }


}
