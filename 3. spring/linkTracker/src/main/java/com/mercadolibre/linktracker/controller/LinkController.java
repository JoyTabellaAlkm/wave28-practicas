package com.mercadolibre.linktracker.controller;

import com.mercadolibre.linktracker.dto.LinkRequestDto;
import com.mercadolibre.linktracker.service.ILinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkController {

    private final ILinkService linkService;

    public LinkController(ILinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/link")
    public ResponseEntity<?> createLink(@RequestBody LinkRequestDto link) {
        return new ResponseEntity<>(linkService.createLink(link), HttpStatus.CREATED);
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<?> redirect(@PathVariable Integer linkId, @RequestParam String password) {
        return ResponseEntity.status(HttpStatus.FOUND)
                .header("Location", linkService.redirect(linkId, password))
                .build();
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<?> getMetrics(@PathVariable Integer linkId) {
        return new ResponseEntity<>(linkService.getMetrics(linkId), HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<?> invalidateLink(@PathVariable Integer linkId) {
        return new ResponseEntity<>(linkService.invalidateLink(linkId), HttpStatus.NO_CONTENT);
    }

}
