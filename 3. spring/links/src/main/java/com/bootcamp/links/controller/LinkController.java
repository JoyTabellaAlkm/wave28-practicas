package com.bootcamp.links.controller;

import com.bootcamp.links.dto.LinkDTO;
import com.bootcamp.links.model.Link;
import com.bootcamp.links.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@RestController
public class LinkController {

    @Autowired
    ILinkService linkService;

    @PostMapping("/link")
    public ResponseEntity<?> agregarLink(@RequestBody LinkDTO linkDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(linkService.agregarLink(linkDTO.getBaseUrl()));
    }

    @GetMapping("/link/{linkId}")
    public RedirectView redirectToOriginal(@PathVariable Integer linkId) {
        LinkDTO urlOptional = linkService.redireccionar(linkId);

        String originalUrl = urlOptional.getBaseUrl();
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(originalUrl);
        redirectView.setStatusCode(HttpStatus.FOUND);

        return redirectView;

    }

}
