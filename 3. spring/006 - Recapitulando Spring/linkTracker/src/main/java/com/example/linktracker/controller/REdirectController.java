package com.example.linktracker.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController()
@RequestMapping("/redirect")
public class REdirectController {
    /*@GetMapping()
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("https://www.google.com/");
    }
    @GetMapping()
    public ResponseEntity<Void> redirect() {
        //String url = linkService.getRedirectUrl(linkId);
        return ResponseEntity.status(HttpStatus.FOUND).header("Location", "https://www.google.com/").build();
    }
}
