package com.bootcamp.linktracker.controller;

import com.bootcamp.linktracker.dto.LinkDto;
import com.bootcamp.linktracker.service.LinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.InvalidUrlException;

@RestController
public class LinkController {
    private final LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/link")
    public ResponseEntity<?> createLink(@RequestBody LinkDto linkDto) {
        validateUrl(linkDto.getUrl());
        return new ResponseEntity<>(linkService.createLink(linkDto), HttpStatus.CREATED);
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<?> redirect(@PathVariable int linkId, @RequestParam(required = false) String password) {
        String url = linkService.redirectionUrl(linkId, password);
        return ResponseEntity.status(HttpStatus.FOUND)
                .header("Location", url)
                .build();
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<?> linkMetrics(@PathVariable int linkId, @RequestParam(required = false) String password) {
        return new ResponseEntity<>(linkService.getMetrics(linkId, password), HttpStatus.OK);
    }

    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<?> invalidateLink(@PathVariable int linkId, @RequestParam(required = false) String password) {
        linkService.invalidateLink(linkId, password);

        return new ResponseEntity<>("Link " + linkId + " invalidado con éxito", HttpStatus.OK);
    }

    private void validateUrl(String url) {
        String regex = "https?://[a-zA-Z0-9\\-.]+\\.com\\b([/?].*)?";

        if (url == null || !url.matches(regex)) {
            throw new InvalidUrlException("Por favor ingrese una url válida");
        }
    }
}
