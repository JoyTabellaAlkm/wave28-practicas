package com.start.linktraker.controller;

import com.start.linktraker.dto.LinkDto;
import com.start.linktraker.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LinkController {

    @Autowired
    private ILinkService linkService;


    @PostMapping("/link")
    public ResponseEntity<?> crearLink(@RequestBody LinkDto linkDto) {

        int createdLinkId = linkService.crearLink(linkDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLinkId);
    }

}
