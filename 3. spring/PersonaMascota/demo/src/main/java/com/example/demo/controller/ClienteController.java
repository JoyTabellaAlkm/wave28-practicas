package com.example.demo.controller;

import com.example.demo.dto.request.ClienteDTO;
import com.example.demo.dto.request.MascotaDTO;
import com.example.demo.service.ClienteServiceImpl;
import com.example.demo.service.MascotaServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ClienteController {

    private final ClienteServiceImpl clienteServiceImpl = new ClienteServiceImpl();

    @PostMapping("/cliente")
    public ResponseEntity<?> agregarCliente(@RequestBody ClienteDTO clienteDto) {
        return ResponseEntity.ok(clienteServiceImpl.agregarPersona(clienteDto));
    }

    @GetMapping("/cliente/{nombre}")
    public ResponseEntity<?> obtenerCliente(@PathVariable String nombre) {
        return new ResponseEntity<>(clienteServiceImpl.obtenerPersona(nombre), HttpStatus.OK);
    }

    @PutMapping("/cliente/{nombre}")
    public ResponseEntity<?> actualizarCliente(@PathVariable String nombre, @RequestBody ClienteDTO clienteDto) {
        return new ResponseEntity<>(clienteServiceImpl.actualizarPersona(nombre, clienteDto), HttpStatus.OK);
    }

    @DeleteMapping("/cliente/{nombre}")
    public ResponseEntity<?> eliminarCliente(@PathVariable String nombre) {
        return new ResponseEntity<>(clienteServiceImpl.eliminarPersona(nombre), HttpStatus.OK);
    }

    @GetMapping("/clientes")
    public ResponseEntity<?> obtenerClientes() {
        return new ResponseEntity<>(clienteServiceImpl.obtenerPersonas(), HttpStatus.OK);
    }

}
