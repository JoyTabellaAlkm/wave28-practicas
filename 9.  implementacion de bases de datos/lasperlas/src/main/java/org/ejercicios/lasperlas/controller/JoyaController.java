package org.ejercicios.lasperlas.controller;

import org.ejercicios.lasperlas.model.Joya;
import org.ejercicios.lasperlas.service.IJoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {

    @Autowired
    IJoyaService joyaServ;

    @GetMapping("")
    public List<Joya> getJoyas() {
        return joyaServ.getJoyas();
    }

    @PostMapping("/new")
    public Long saveJoya(@RequestBody Joya joya) {
        return joyaServ.saveJoya(joya);
    }

    //eliminado logico, tenemos q poner venta en false, es solo actualizat
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> eliminarLogico(@PathVariable Long id) {
        joyaServ.deleteJoya(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<?> updateJoya(@PathVariable Long id_modificar, @RequestBody Joya joyaModif){
        return ResponseEntity.ok(joyaServ.editJoya(id_modificar, joyaModif));
    }

}
