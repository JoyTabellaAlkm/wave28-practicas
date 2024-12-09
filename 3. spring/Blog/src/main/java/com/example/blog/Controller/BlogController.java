package com.example.blog.Controller;

import com.example.blog.DTO.EntryBlogDTO;
import com.example.blog.Service.Implementation.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/blog")
    public ResponseEntity<Boolean> createBlog(@RequestBody EntryBlogDTO entryBlogDTO) {
        return new ResponseEntity<>(blogService.createEntryBlog(entryBlogDTO), HttpStatus.CREATED);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<EntryBlogDTO> getBlogById(@PathVariable Integer id) {
        return new ResponseEntity<>(blogService.getEntryById(id), HttpStatus.OK);
    }

    @GetMapping("/blogs")
    public ResponseEntity<List<EntryBlogDTO>> getAllBlogs() {
        return new ResponseEntity<>(blogService.findAll(), HttpStatus.OK);
    }
}
