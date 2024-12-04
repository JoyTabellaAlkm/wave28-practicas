package com.example.demo;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @GetMapping("/{nombre}")
    public String hola(@PathVariable String nombre){
        return ("Hola "+nombre);
    }
    @GetMapping("")
    public String holaParam(@RequestParam String nombre){
        return ("Hola "+nombre);
    }

}
