package com.bootcamp.ejercicio_links.controller;

import com.bootcamp.ejercicio_links.dto.LinkDto;
import com.bootcamp.ejercicio_links.service.ILinksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkController {
    @Autowired
    private ILinksService service;

    @PostMapping("/link")
    public ResponseEntity<?> newLink (@RequestBody LinkDto newLink){
        return new ResponseEntity<>(service.create(newLink), HttpStatus.CREATED);
    }


    @GetMapping("/metrics/{linkID}")
    public ResponseEntity<?> metricById(@PathVariable Long linkID){
        return new ResponseEntity<>(service.metrics(linkID), HttpStatus.OK);

    }

    @DeleteMapping("/invalidate/{linkId}")
    public ResponseEntity<?> invalidateLink(@PathVariable Long linkId){
        service.invalidate(linkId);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @GetMapping("/link/{linkId}")
    public ResponseEntity<?> redirect(@PathVariable Long linkId,
                                      @RequestParam(required = false) String password){
        String url = service.redirect(linkId,password);
        return ResponseEntity.status(302)
                .header("Location", url)
                .build();
    }

}
