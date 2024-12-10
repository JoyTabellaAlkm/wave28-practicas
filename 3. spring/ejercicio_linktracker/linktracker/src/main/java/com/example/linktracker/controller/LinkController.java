package com.example.linktracker.controller;

import com.example.linktracker.dto.LinkRequestDTO;
import com.example.linktracker.dto.LinkResponseDTO;
import com.example.linktracker.dto.MetricsResponseDTO;
import com.example.linktracker.service.ILinkService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;

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

    @GetMapping("/link/{linkID}")
    public void redirect(@PathVariable("linkID") int linkID, HttpServletResponse httpServletResponse) {
        String url = linkService.getLinkById(linkID);
        try {
            httpServletResponse.sendRedirect(url);
        } catch (Exception ignored) {
        }
    }

    @GetMapping("/metrics/{linkID}")
    public ResponseEntity<MetricsResponseDTO> getMetrics(@PathVariable("linkID") int linkID) {
        return ResponseEntity.ok(linkService.getMetrics(linkID));
    }

    @PostMapping("invalidate/{linkID}")
    public ResponseEntity<String> invalidate(@PathVariable("linkID") int linkID) {
        linkService.invalidate(linkID);
        return ResponseEntity.ok("done");
    }
}
