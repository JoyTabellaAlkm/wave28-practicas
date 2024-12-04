package com.example.demo.controllers;

import com.example.demo.services.MorseCode;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/demo/v0.2", produces = MediaType.APPLICATION_JSON_VALUE)
public class MorseRestController {

    @GetMapping("hello")
    public String hello(){
        return "hola mundo";
    }

    @GetMapping("/convert")
    public String convert(@RequestParam MorseCode codes){
        return codes.convert();
    }
    @GetMapping("/convert/{codes}")
    public String convertByPath(@PathVariable MorseCode codes){
        return codes.convert();
    }

    @PostMapping("/convert")
    public String convertByPost(@RequestBody MorseCode codes){
        return codes.convert();
    }
}
