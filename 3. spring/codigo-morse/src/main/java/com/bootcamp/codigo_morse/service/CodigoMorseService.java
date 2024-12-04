package com.bootcamp.codigo_morse.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CodigoMorseService {
    private final Map<String, String> traductor;

    public CodigoMorseService() {
        this.traductor = new HashMap<>();
        buildTraductor();
    }

    public String traduccionAlEspanol(String codigoMorse) {
        List<List<String>> letrasPorPalabra = getLetrasPorPalabra(codigoMorse);

        return traduccion(letrasPorPalabra);
    }

    private String traduccion(List<List<String>> letrasPorPalabra) {
        return letrasPorPalabra
                .stream()
                .map(this::palabraMorseAPalabraEspanol)
                .collect(Collectors.joining(" "));
    }

    private List<List<String>> getLetrasPorPalabra(String codigoMorse) {
        List<String> palabras = List.of(codigoMorse.split("   "));

        return palabras
                .stream()
                .map(this::separarLetrasDePalabra)
                .toList();
    }

    private List<String> separarLetrasDePalabra(String palabra) {
        return Arrays.stream(palabra.split(" ")).toList();
    }

    private String palabraMorseAPalabraEspanol(List<String> palabraMorse) {
        return palabraMorse
                .stream()
                .map(this::letraMorseALetraEspanol)
                .collect(Collectors.joining(""));
    }

    private String letraMorseALetraEspanol(String letraMorse) {
        return traductor.get(letraMorse);
    }

    private void buildTraductor() {
        traductor.put(".-", "A");
        traductor.put("-...", "B");
        traductor.put("-.-.", "C");
        traductor.put("-..", "D");
        traductor.put(".", "E");
        traductor.put("..-.", "F");
        traductor.put("--.", "G");
        traductor.put("....", "H");
        traductor.put("..", "I");
        traductor.put(".---", "J");
        traductor.put("-.", "K");
        traductor.put(".-..", "L");
        traductor.put("--", "M");
        traductor.put("-.", "N");
        traductor.put("---", "O");
        traductor.put(".--.", "P");
        traductor.put("--.-", "Q");
        traductor.put(".-.", "R");
        traductor.put("...", "S");
        traductor.put("-", "T");
        traductor.put("..-", "U");
        traductor.put("...-", "V");
        traductor.put(".--", "W");
        traductor.put("-..-", "X");
        traductor.put("-.--", "Y");
        traductor.put("--..", "Z");
        traductor.put(".----", "1");
        traductor.put("..---", "2");
        traductor.put("...--", "3");
        traductor.put("....-", "4");
        traductor.put(".....", "5");
        traductor.put("-....", "6");
        traductor.put("--...", "7");
        traductor.put("---..", "8");
        traductor.put("----.", "9");
        traductor.put("-----", "0");
        traductor.put("..--..", "?");
        traductor.put("-.-.--", "!");
        traductor.put(".-.-.-", ".");
        traductor.put("--..--", ",");
    }
}
