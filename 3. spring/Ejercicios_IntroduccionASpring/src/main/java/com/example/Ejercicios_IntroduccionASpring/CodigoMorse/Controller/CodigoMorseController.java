package com.example.Ejercicios_IntroduccionASpring.CodigoMorse.Controller;

import com.example.Ejercicios_IntroduccionASpring.CodigoMorse.Service.CodigoMorseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CodigoMorseController {
    private final CodigoMorseService service = new CodigoMorseService();

    @GetMapping("/traduccionAlEspanol")
    public String traduccionAlEspanol(@RequestParam String codigoMorse) {
        return service.traduccionAlEspanol(codigoMorse);
    }
}
