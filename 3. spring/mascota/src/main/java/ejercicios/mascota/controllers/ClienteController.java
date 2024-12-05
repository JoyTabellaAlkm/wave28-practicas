package ejercicios.mascota.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    @PostMapping("/cliente")
    public ResponseEntity<?> agregarCliente(){

    }
}
