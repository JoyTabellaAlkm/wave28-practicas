package com.mercadolibre.miniseries.controller;

import com.mercadolibre.miniseries.dto.request.MiniSerieDTO;
import com.mercadolibre.miniseries.dto.response.MiniSerieDTOResponse;
import com.mercadolibre.miniseries.service.IMiniseriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MiniserieController {
    @Autowired
    private IMiniseriesService miniseriesService;

    @PostMapping("/create")
    public MiniSerieDTOResponse createMiniserie(@RequestBody MiniSerieDTO miniserie) {
        return miniseriesService.saveMiniSerie(miniserie);
    }

    @GetMapping("/find/{id}")
    public MiniSerieDTOResponse createMiniserie(@PathVariable Long id) {
        return miniseriesService.findMiniserie(id);
    }
}
