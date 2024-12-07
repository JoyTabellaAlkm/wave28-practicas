package co.com.mercadolibre.morseConverter.controller;

import co.com.mercadolibre.morseConverter.model.Morse;
import co.com.mercadolibre.morseConverter.service.MorseConvertService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/convert")
public class MorseConverterController {

    private final MorseConvertService morseConvertService;

    public MorseConverterController(MorseConvertService morseConvertService) {
        this.morseConvertService = morseConvertService;
    }

    @PostMapping
    public String convertToWords(@RequestBody Morse morse) {
        return morseConvertService.convertToWords(morse.getCode());
    }
}
