package com.bootcamp.linktracker.controller;

import com.bootcamp.linktracker.dto.UrlDto;
import com.bootcamp.linktracker.service.LinkService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.InvalidUrlException;

@RestController
public class LinkController {
    private final LinkService linkService;

    public LinkController(LinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("link")
    public ResponseEntity<?> createLink(@RequestBody UrlDto urlDto) {
        validateUrl(urlDto.getUrl());
        return new ResponseEntity<>(linkService.createLink(urlDto.getUrl()), HttpStatus.CREATED);
    }

    void validateUrl(String url) {
        String regex = "https?:\\/\\/[a-zA-Z0-9\\-\\.]+\\.com\\b([\\/\\?].*)?";
//        !url.matches(regex)
        if (url == null || !url.matches(regex)) {
            throw new InvalidUrlException("Por favor ingrese una url válida" + url);
        }
    }
}
