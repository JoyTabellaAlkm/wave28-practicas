package com.mercadolibre.linktracker.controller;

import com.mercadolibre.linktracker.dto.Request.LinkRequestDTO;
import com.mercadolibre.linktracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class LinkTrackerController {

    @Autowired
    private ILinkService linkService;

    @PostMapping("/link")
    public ResponseEntity<?> crearLink(@RequestBody LinkRequestDTO link){
        return new ResponseEntity<>(linkService.crearLink(link), HttpStatus.CREATED);
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<?> redireccionar(@PathVariable Long linkId) {
        String redirectUrl = linkService.redirect(linkId);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(redirectUrl));
        return new ResponseEntity<>(headers, HttpStatus.PERMANENT_REDIRECT);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<?> obtenerMetricas(@PathVariable Long linkId){
        return new ResponseEntity<>(linkService.obtenerMetricas(linkId), HttpStatus.OK);
    }

    @PatchMapping("/invalidate/{linkId}")
    public ResponseEntity<?> invalidarLink(@PathVariable Long linkId){
        return new ResponseEntity<>(linkService.invalidarLink(linkId), HttpStatus.OK);
    }

}
