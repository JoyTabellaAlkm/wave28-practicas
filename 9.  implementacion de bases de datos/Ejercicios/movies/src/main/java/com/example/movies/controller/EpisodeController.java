package com.example.movies.controller;

import com.example.movies.entity.Episode;
import com.example.movies.service.IEpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/episodes")
@RestController
public class EpisodeController {
    @Autowired
    IEpisodeService episodeService;

    @GetMapping
    ResponseEntity<List<Episode>> getEpisodesByActor(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName){
        return new ResponseEntity<>(episodeService.listEpisodesByActor(firstName,lastName), HttpStatus.OK);
    }
}
