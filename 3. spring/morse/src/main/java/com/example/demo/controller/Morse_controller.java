package com.example.demo.controller;

import com.example.demo.service.Morse_service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/morse")
public class Morse_controller {

    Morse_service morse_service = new Morse_service();

    @GetMapping("/encoder")
    public String encoder_morse(@RequestParam String s) {
        return morse_service.to_morse(s);
    }

    @GetMapping("/decoder")
    public String decoder_morse(@RequestParam String s) {
        return morse_service.to_word(s);
    }
}
