package com.bootcamp.ejercicio2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class MorseController {

    private static final Map<String, Character> CONVERSIONS = new HashMap<>();

    static {
        CONVERSIONS.put(".-", 'A');
        CONVERSIONS.put("-...", 'B');
        CONVERSIONS.put("-.-.", 'C');
        CONVERSIONS.put("-..", 'D');
        CONVERSIONS.put(".", 'E');
        CONVERSIONS.put("..-.", 'F');
        CONVERSIONS.put("--.", 'G');
        CONVERSIONS.put("....", 'H');
        CONVERSIONS.put("..", 'I');
        CONVERSIONS.put(".---", 'J');
        CONVERSIONS.put("-.-", 'K');
        CONVERSIONS.put(".-..", 'L');
        CONVERSIONS.put("--", 'M');
        CONVERSIONS.put("-.", 'N');
        CONVERSIONS.put("---", 'O');
        CONVERSIONS.put(".--.", 'P');
        CONVERSIONS.put("--.-", 'Q');
        CONVERSIONS.put(".-.", 'R');
        CONVERSIONS.put("...", 'S');
        CONVERSIONS.put("-", 'T');
        CONVERSIONS.put("..-", 'U');
        CONVERSIONS.put("...-", 'V');
        CONVERSIONS.put(".--", 'W');
        CONVERSIONS.put("-..-", 'X');
        CONVERSIONS.put("-.--", 'Y');
        CONVERSIONS.put("--..", 'Z');
        CONVERSIONS.put("-----", '0');
        CONVERSIONS.put(".----", '1');
        CONVERSIONS.put("..---", '2');
        CONVERSIONS.put("...--", '3');
        CONVERSIONS.put("....-", '4');
        CONVERSIONS.put(".....", '5');
        CONVERSIONS.put("-....", '6');
        CONVERSIONS.put("--...", '7');
        CONVERSIONS.put("---..", '8');
        CONVERSIONS.put("----.", '9');
        CONVERSIONS.put("..--..", '?');
        CONVERSIONS.put("-.-.--", '!');
        CONVERSIONS.put(".-.-.-", '.');
        CONVERSIONS.put("--..--", ',');
    }

    @GetMapping("/convert/{code}")
    public String convert(@PathVariable String code) {
        return Arrays.stream(code.split("\\s{3}"))
                .map(this::convertWord)
                .collect(Collectors.joining(" "));
    }

    private String convertWord(String word) {
        return Arrays.stream(word.split("\\s+"))
                .map(c -> CONVERSIONS.get(c).toString())
                .collect(Collectors.joining());
    }

}
