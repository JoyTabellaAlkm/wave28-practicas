package com.ar.mercadolibre.linktracker.controller;

import com.ar.mercadolibre.linktracker.dto.request.LinkRequestDto;
import com.ar.mercadolibre.linktracker.service.ILinkService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
public class LinkController {
    private final ILinkService linkService;

    public LinkController(ILinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/link/{linkId}")
    public ResponseEntity<?> createMaskedUrl(@PathVariable String linkId, @RequestBody LinkRequestDto linkRequestDto) {
        return new ResponseEntity<>(linkService.createMaskedUrl(linkId, linkRequestDto), HttpStatus.CREATED);
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<?> redirectToUrl(@PathVariable String linkId, @RequestParam(required = false) String password) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location", linkService.redirect(linkId, password));
        return new ResponseEntity<>("Redirecting", httpHeaders, HttpStatus.FOUND);
    }

    @GetMapping("/metrics/{linkID}")
    public ResponseEntity<?> getLinkMetrics(@PathVariable String linkID) {
        return new ResponseEntity<>(linkService.getMetricsById(linkID), HttpStatus.OK);
    }

    @DeleteMapping("/invalidate/{linkID}")
    public ResponseEntity<?> delete(@PathVariable String linkID) {
        linkService.delete(linkID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
