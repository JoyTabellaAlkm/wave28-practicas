package com.bootcamp.movies_api.controller;

import com.bootcamp.movies_api.service.EpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/episodes")
public class EpisodeRestController {

    EpisodeService episodeService;

    @Autowired
    public EpisodeRestController(EpisodeService episodeService) {
        this.episodeService = episodeService;
    }

    @GetMapping
    ResponseEntity<?> findAll() {
        return ResponseEntity.ok(episodeService.findAll());
    }

    @GetMapping("/actor/{id}")
    ResponseEntity<?> findAllByActor(@PathVariable Long id) {
        return ResponseEntity.ok(episodeService.findAllByActor(id));
    }
}
