package com.meli.be_java_hisp_w28_g01.controller;

import com.meli.be_java_hisp_w28_g01.dto.request.PostDto;
import com.meli.be_java_hisp_w28_g01.dto.request.PromoPostDto;
import com.meli.be_java_hisp_w28_g01.service.IPostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class PostController {

    IPostService service;

    public PostController(IPostService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public ResponseEntity<?> listAllPosts (){
        return ResponseEntity.ok().body(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPostById (@PathVariable int id){
        return ResponseEntity.ok().body(service.getByid(id));
    }
    @GetMapping("/type/{productType}")
    public ResponseEntity<?> listPostByProductType (@PathVariable String productType) {
        return ResponseEntity.ok().body(service.getByProductType(productType));
    }


    @PostMapping("/post")
    public ResponseEntity<?> addPost(@Validated @RequestBody PostDto postDto){
        return ResponseEntity.ok().body(service.add(postDto));
    }

    @PostMapping("/promo-post")
    public ResponseEntity<?> addPromoPost(@Validated @RequestBody PromoPostDto promoPostDto){
        return ResponseEntity.ok().body(service.addPromoPost(promoPostDto));
    }

    @GetMapping("/promo-post/count")
    public ResponseEntity<?> getPromoPostsCount(@RequestParam int user_id){
        return new ResponseEntity<>(service.getPromoPostCount(user_id), HttpStatus.OK);
    }

    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<?> getProducts(@PathVariable int userId, @RequestParam(required = false) String order )
    {
        if (order==null){
            return ResponseEntity.ok().body(service.getPostsByUser(userId));
        }else {
            return ResponseEntity.ok().body(service.getPostByUserOrderedByDate(userId, order));
        }
    }


}
