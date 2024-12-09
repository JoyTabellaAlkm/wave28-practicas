package com.mercadolibre.blog.controller;

import com.mercadolibre.blog.dto.BlogDTO;
import com.mercadolibre.blog.exception.NotFoundException;
import com.mercadolibre.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BlogController {
    @Autowired
    BlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<?> agregarEntradaBlog(@RequestBody BlogDTO entradaBlogDto){
        return new ResponseEntity<>(blogService.agregarEntradaBlog(entradaBlogDto), HttpStatus.CREATED);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<?> devolverBlog(@PathVariable Long id){
        BlogDTO blogDTO = blogService.devolverBlog(id);
        if (blogDTO == null){
            throw new NotFoundException("No existe un blog asociado a este id.");
        }
        return new ResponseEntity<>(blogService.devolverBlog(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<?> devolverBlogs(){
        return new ResponseEntity<>(blogService.devolverBlogs(),HttpStatus.OK);
    }
}
