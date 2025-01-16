package com.example.peliculas.controller;


import com.example.peliculas.dto.ActorDTO;
import com.example.peliculas.dto.MessageDTO;
import com.example.peliculas.service.IActorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/actores")
public class ActorController {

    private IActorService actorService;

    public ActorController(IActorService actorService) {
        this.actorService = actorService;
    }

    @PostMapping("/create")
    public ResponseEntity<MessageDTO> create(@RequestBody ActorDTO actor){
        actorService.create(actor);
        return new ResponseEntity<>(new MessageDTO("creado","201"), HttpStatus.CREATED);

    }
}
