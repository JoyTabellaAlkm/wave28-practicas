package com.redirect.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.redirect.dto.UrlDTO;
import com.redirect.dto.response.IdUrlDTO;
import com.redirect.service.IUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class RedirectRestController {

    @Autowired
    private IUrlService urlService;

    @Autowired
    private ObjectMapper objectMapper;

    @PostMapping("/createLink")
    public ResponseEntity<?> createLink(@RequestBody UrlDTO urlDTO) throws URISyntaxException {
        IdUrlDTO id = urlService.createUrl(urlDTO);
        return ResponseEntity.ok(id);
    }

    @GetMapping("link/{linkId}")
    public ResponseEntity<?> redirectLink(@PathVariable String linkId) throws URISyntaxException {
        URI redirectUrl = new URI(urlService.getUrl(new IdUrlDTO(linkId)).getUrl());
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(redirectUrl);
        return new ResponseEntity<>(httpHeaders, HttpStatus.SEE_OTHER);
    }

    @GetMapping("/metrics/{linkId}")
    public ResponseEntity<?> getMetrics(@PathVariable String linkId){
        return ResponseEntity.ok(urlService.getEstats(new IdUrlDTO(linkId)));
    }


    @PostMapping("/invalidate/{linkId}")
    public ResponseEntity<?> invalidateLink(@PathVariable String linkId){
        return ResponseEntity.ok(urlService.disableUrl(new IdUrlDTO(linkId)));
    }
}
