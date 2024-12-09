package com.example.Ejercicio_LinkTracker.controller;

import com.example.Ejercicio_LinkTracker.dto.LinkDto;
import com.example.Ejercicio_LinkTracker.service.LinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping()
public class LinkController {

    private final LinkService service;


    public LinkController(LinkService service) {
        this.service = service;
    }

    @PostMapping("/link")
    public ResponseEntity<?> createLink(@RequestBody LinkDto linkDto){

        return ResponseEntity.ok().body("Se creó tu link de redirección con el id: " + service.create(linkDto));
    }

    @GetMapping("/link/{id}")
    public RedirectView redirect(@PathVariable Integer id) {
        return  service.redirect(id);
    }
}
