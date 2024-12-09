package com.bootcamp.linktracker.controller;

import com.bootcamp.linktracker.dto.LinkDTO;
import com.bootcamp.linktracker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.http.HttpResponse;

@RestController
public class LinkController {

    @Autowired
    private ILinkService linkService;

    @PostMapping("/links")
    public ResponseEntity<?> createLink(@RequestBody LinkDTO linkDTO) {
        return ResponseEntity.ok(linkService.createLink(linkDTO));
    }

    @GetMapping("/links/{id}")
    public ResponseEntity<?> redirect(@PathVariable Integer id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create(linkService.redirect(id)));
        return new ResponseEntity<>(headers, HttpStatus.SEE_OTHER);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<?> getRedirectCount(@PathVariable Integer linkId) {
        return ResponseEntity.ok(linkService.countRedirections(linkId));
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<?> invalidate(@PathVariable Integer linkId) {
        //linkService.invalidate(linkId);
        return ResponseEntity.noContent().build();
    }
}
