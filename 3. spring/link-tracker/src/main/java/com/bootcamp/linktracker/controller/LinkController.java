package com.bootcamp.linktracker.controller;

import com.bootcamp.linktracker.dto.RequestPostCreacionLinkDto;
import com.bootcamp.linktracker.dto.RequestRedireccionDto;
import com.bootcamp.linktracker.dto.ResponseRedireccion;
import com.bootcamp.linktracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("link")
public class LinkController {
    @Autowired
    private ILinkService linkService;

    @PostMapping
    public ResponseEntity<?> crearLink(@RequestBody RequestPostCreacionLinkDto request) {
        return new ResponseEntity<>(linkService.crearLink(request), HttpStatus.CREATED);
    }

    @GetMapping("/{linkId}")
    public ResponseEntity<Void> redireccionLink(@PathVariable Long linkId, @RequestParam String password) {
        ResponseRedireccion linkRedireccion = linkService.redireccionLink(new RequestRedireccionDto(linkId, password));
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(linkRedireccion.getLink()));
        return new ResponseEntity<>(headers, HttpStatus.FOUND);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<?> obtenerMetricas(@PathVariable Long linkId) {
        return new ResponseEntity<>(linkService.obtenerMetricas(linkId), HttpStatus.OK);
    }
}
