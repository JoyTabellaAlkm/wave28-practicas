package com.mercadolibre.movies_hql.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mercadolibre.movies_hql.service.ISerieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/series")
public class SerieController {

    @Autowired
    private ISerieService serieService;

    @GetMapping("/season-quantity-up/{quantitySeason}")
    public ResponseEntity<?> findAllBySeasonQuantityUp(@PathVariable int quantitySeason) {
        return ResponseEntity.ok(serieService.findAllBySeasonQuantityUp(quantitySeason));
    }

    @GetMapping("/episodes/actor/{actorId}")
    public ResponseEntity<?> findAllEpisodesByActor(@PathVariable int actorId) {
        return ResponseEntity.ok(serieService.findAllEpisodesByActor(actorId));
    }

}
