package com.codigomorse.codigomorse.controller;
import com.bootcamp.codigo_morse.service.CodigoMorseService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CodigoMorseController {

    private final CodigoMorseService service = new CodigoMorseService();

    @GetMapping("/traduccionAlEspanol")
    public String traduccionAlEspanol(@RequestParam String codigoMorse) {
        return service.traduccionAlEspanol(codigoMorse);
    }

}
