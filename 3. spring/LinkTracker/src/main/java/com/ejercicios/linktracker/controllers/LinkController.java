package com.ejercicios.linktracker.controllers;

import com.ejercicios.linktracker.dtos.requestDto.LinkDTO;
import com.ejercicios.linktracker.services.ILinkService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class LinkController {

    @Autowired
    private ILinkService linkService;

    @PostMapping("/link")
    public ResponseEntity<?> newLink(@RequestBody LinkDTO link){
        return new ResponseEntity<>(linkService.addLink(link), HttpStatus.OK);
    }

    @GetMapping("/link/{id}")
    public ResponseEntity<?> redirect(@PathVariable int id) {
       return ResponseEntity.status(302)
                .header("Location", linkService.findLink(id))
                .build();
    }



}
