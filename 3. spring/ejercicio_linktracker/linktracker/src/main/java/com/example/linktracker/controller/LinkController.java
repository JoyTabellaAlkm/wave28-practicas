package com.example.linktracker.controller;

import com.example.linktracker.dto.LinkRequestDTO;
import com.example.linktracker.dto.LinkResponseDTO;
import com.example.linktracker.service.ILinkService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LinkController {
    private final ILinkService linkService;

    @Autowired
    public LinkController(ILinkService linkService) {
        this.linkService = linkService;
    }

    @PostMapping("/link")
    public ResponseEntity<LinkResponseDTO> createLink(@RequestBody LinkRequestDTO request) {
        return ResponseEntity.ok(linkService.createLink(request.getUrl()));
    }

    @GetMapping("/link/{linkId}")
    public void redirect(@PathVariable int linkId, HttpServletResponse httpServletResponse) {
        String url = linkService.getLinkById(linkId);
        try {
            httpServletResponse.sendRedirect(url);
        } catch (Exception ignored) {
        }
    }
}
