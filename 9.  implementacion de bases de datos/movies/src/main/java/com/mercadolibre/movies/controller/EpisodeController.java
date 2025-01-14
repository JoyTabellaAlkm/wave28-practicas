package com.mercadolibre.movies.controller;

import com.mercadolibre.movies.dto.EpisodeDto;
import com.mercadolibre.movies.service.IEpisodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/episode")
public class EpisodeController {
    @Autowired
    IEpisodeService episodeService;

    @GetMapping("")
    public ResponseEntity<List<EpisodeDto>> obtenerEpisodiosPorActor(@RequestParam String nombre,
                                                                     @RequestParam String apellido){
        return ResponseEntity.ok(episodeService.obtenerEpisodiosPorActor(nombre,apellido));
    }
}
