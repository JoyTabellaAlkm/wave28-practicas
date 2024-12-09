package com.bootcamp.link_tracker.controller;

import com.bootcamp.link_tracker.dto.LinkTrackDTO;
import com.bootcamp.link_tracker.service.LinkTrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkTrackRestController {

    private final LinkTrackService linkTrackService;

    @Autowired
    public LinkTrackRestController(LinkTrackService linkTrackService) {
        this.linkTrackService = linkTrackService;
    }

    @GetMapping("/links")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(linkTrackService.findAll());
    }

    @GetMapping("/links/{linkId}")
    public ResponseEntity<?> findById(@PathVariable Long linkId) {
        return ResponseEntity.ok(linkTrackService.findById(linkId));
    }

    @PostMapping("/links")
    public ResponseEntity<?> create(@RequestBody LinkTrackDTO linkTrackDTO) {
        return new ResponseEntity<>(linkTrackService.createLinkTrack(linkTrackDTO), HttpStatus.CREATED);
    }

    // Redirect
    @GetMapping("/link/{linkId}")
    public ResponseEntity<?> redirect(@PathVariable Long linkId) {
        HttpHeaders headers = new HttpHeaders();
        String urlToRedirect = linkTrackService.redirectById(linkId);
        headers.add("Location", urlToRedirect);
        return new ResponseEntity<>("Redireccionando", headers,  HttpStatus.PERMANENT_REDIRECT);
    }
}
