package com.ejercicioblog.blog.controller;

import com.ejercicioblog.blog.dot.EntradaBlogDot;
import com.ejercicioblog.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BlogController {
    @Autowired
    IBlogService service;

    @GetMapping("/blog")
    public ResponseEntity<List<EntradaBlogDot>> listarTodas(){
        return new ResponseEntity<>(service.listarTodas(),HttpStatus.OK);
    }
}
