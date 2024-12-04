package com.example.Ejercicios_IntroduccionASpring.NumerosRomanos.Controller;

import com.example.Ejercicios_IntroduccionASpring.NumerosRomanos.Model.NroDecimal;
import com.example.Ejercicios_IntroduccionASpring.NumerosRomanos.Service.NroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/NumerosRomanos")
@RequiredArgsConstructor
public class NroController {

    private final NroService service;

    @GetMapping("/convert/{nroDec}")
    public ResponseEntity<String> convertirDecimalARomano(@PathVariable Double nroDec){
            NroDecimal nroDecimal = new NroDecimal();
            nroDecimal.setValor(nroDec);
            return service.convertirDecimalANroRomano(nroDecimal);
    }
}
