package com.example.ejerciciolinks.controller;

import com.example.ejerciciolinks.dto.LinkDTO;
import com.example.ejerciciolinks.repository.ILinkRepository;
import com.example.ejerciciolinks.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.net.URI;

@RestController
public class LinkController {

    @Autowired
    ILinkRepository repository;
    @Autowired
    ILinkService service;

    @PostMapping("/link")
    public ResponseEntity<?> newLink(@RequestBody LinkDTO newLink) {
        return new ResponseEntity<>(service.saveLink(newLink), HttpStatus.CREATED);
    }


    @GetMapping("/metrics/{linkID}")
    public ResponseEntity<?> metricById(@PathVariable Integer linkID) {
        return new ResponseEntity<>(service.getLinkMetrics(linkID), HttpStatus.OK);

    }

    @GetMapping("")
    public ResponseEntity<?> getById() {
        return new ResponseEntity<>(repository.getAllLink(), HttpStatus.OK);

    }

    @DeleteMapping("/invalidate/{linkId}")
    public ResponseEntity<?> invalidateLink(@PathVariable Integer linkId) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<?> redirect(@PathVariable int linkId, @RequestParam(required = false) String password) {
        LinkDTO linkDTO = service.redirect(linkId, password);
        return ResponseEntity.status(302)
                .header("Location", linkDTO.getUrl())
                .build();
    }

}
