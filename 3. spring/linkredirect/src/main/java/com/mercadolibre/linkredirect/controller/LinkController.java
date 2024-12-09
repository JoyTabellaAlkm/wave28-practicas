package com.mercadolibre.linkredirect.controller;

import com.mercadolibre.linkredirect.dto.LinkDtoRequest;
import com.mercadolibre.linkredirect.service.ILinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkController {

    @Autowired
    private ILinkService linkService;

    @PostMapping("link")
    public ResponseEntity<Long> postLink(@RequestBody LinkDtoRequest linkDtoRequest){
        return new ResponseEntity<>(linkService.addLink(linkDtoRequest), HttpStatus.CREATED);
    }
    @GetMapping("/link/{linkId}")
    public ResponseEntity<Void> redirect(@PathVariable Long linkId, @RequestParam String password) {
        String url = linkService.viewLinkById(linkId,password).getLink();
        return ResponseEntity.status(HttpStatus.FOUND).header("Location", url).build();
    }

    @GetMapping("metrics/{linkId}")
    public ResponseEntity<?>  getLinkMetrics(@PathVariable Long linkId){
        return new ResponseEntity<>(linkService.getById(linkId),HttpStatus.OK);
    }

}
