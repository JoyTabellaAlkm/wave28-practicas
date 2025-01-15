package com.bootcamp.joyeria.controller;


import com.bootcamp.joyeria.dto.req.JoyaCreationReqDto;
import com.bootcamp.joyeria.dto.req.JoyaUpdateReqDto;
import com.bootcamp.joyeria.dto.res.JoyaCreationResDto;
import com.bootcamp.joyeria.dto.res.JoyaGetDto;
import com.bootcamp.joyeria.dto.res.JoyaUpdateResDto;
import com.bootcamp.joyeria.service.JoyaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewelry")
public class JoyaController {
    @Autowired
    private JoyaService joyaService;

    @PostMapping("/new")
    ResponseEntity<JoyaCreationResDto> createJoya(@RequestBody JoyaCreationReqDto dto) {
        JoyaCreationResDto joya = joyaService.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(joya);
    }

    @GetMapping
    ResponseEntity<List<JoyaGetDto>> getAllJoyas() {
        return ResponseEntity.ok(joyaService.getAll());
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<Void> deleteJoya(@PathVariable Long id) {
        joyaService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update/{id}")
    ResponseEntity<JoyaUpdateResDto> updateJoya(@PathVariable Long id, @RequestBody JoyaUpdateReqDto dto) {
        return ResponseEntity.ok(joyaService.update(id, dto));
    }
}
