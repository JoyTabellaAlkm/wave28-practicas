package com.obras_literarias.controller;

import com.obras_literarias.DTO.ObraDto;
import com.obras_literarias.service.IObraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class ObraController {
    @Autowired
    private IObraService obraService;

    @PostMapping("/obra")
    public ResponseEntity<ObraDto> createObra(@RequestBody ObraDto obra){
        return ResponseEntity.ok(obraService.createObra(obra));
    }
}
