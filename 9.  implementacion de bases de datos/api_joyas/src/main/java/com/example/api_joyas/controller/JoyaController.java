package com.example.api_joyas.controller;

import com.example.api_joyas.model.Joya;
import com.example.api_joyas.service.JoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jewerly")
public class JoyaController {
    @Autowired
    JoyaService joyaService;

    @GetMapping
    public ResponseEntity<?> getJoyas(){
        return ResponseEntity.ok().body(joyaService.getJoyas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findJoya(@PathVariable Long id){
        return ResponseEntity.ok().body(joyaService.findJoya(id));
    }

    @PostMapping("/new")
    public ResponseEntity<?> createJoya(@RequestBody Joya joya){
        return ResponseEntity.ok().body(joyaService.createJoya(joya));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteJoya(@PathVariable Long id){
        return ResponseEntity.ok().body(joyaService.deleteJoya(id));
    }

    @PutMapping("/update/{id_modificar}")
    public ResponseEntity<?> updateJoya(@PathVariable Long id_modificar,
                                        @RequestBody Joya joya){
       return ResponseEntity.ok().body(joyaService.updateJoya(id_modificar,joya));
    }

}
