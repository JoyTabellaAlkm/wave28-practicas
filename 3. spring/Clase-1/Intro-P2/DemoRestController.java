package com.example.demo;

import com.example.demo.model.Conversor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/demo")
public class DemoRestController {

    @GetMapping("/numero/{num}")
    public String romanizarNumero(@PathVariable String num) {
        return Conversor.convertirARomano(num);
    }
}
