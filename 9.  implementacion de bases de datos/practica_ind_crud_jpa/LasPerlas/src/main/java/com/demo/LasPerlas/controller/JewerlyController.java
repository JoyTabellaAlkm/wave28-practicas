package com.demo.LasPerlas.controller;

import com.demo.LasPerlas.dto.JewelDto;
import com.demo.LasPerlas.dto.MessageDto;
import com.demo.LasPerlas.service.IJewerlyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jewerly")
public class JewerlyController {

    private final IJewerlyService jewerlyService;

    public JewerlyController(IJewerlyService jewerlyService){
        this.jewerlyService = jewerlyService;
    }

    @PostMapping("/new")
    public ResponseEntity<Long> post(@RequestBody JewelDto dto) {
        return new ResponseEntity<>(jewerlyService.post(dto), HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<JewelDto>> getAll() {
        return ResponseEntity.ok(jewerlyService.getAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessageDto> delete(@PathVariable("id") Long id) {
        jewerlyService.delete(id);
        return new ResponseEntity<>(new MessageDto("Joya eliminada exitosamente."), HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<MessageDto> update(@PathVariable("id") Long id,
                                                @RequestBody JewelDto dto) {
        jewerlyService.update(id, dto);
        return new ResponseEntity<>(new MessageDto("Joya modificada exitosamente."), HttpStatus.NO_CONTENT);
    }
}
