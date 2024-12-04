package com.example.codigomorse.servicio;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TraducirService {
    public String traducir(String codigo) {
        Map<String, String> morseToTexto = new HashMap<String, String>() {{
            put(".-", "A");
            put("-...", "B");
            put("-.-.", "C");
            put("-..", "D");
            put(".", "E");
            put("..-.", "F");
            put("--.", "G");
            put("....", "H");
            put("..", "I");
            put(".---", "J");
            put("-.-", "K");
            put(".-..", "L");
            put("--", "M");
            put("-.", "N");
            put("---", "O");
            put(".--.", "P");
            put("--.-", "Q");
            put(".-.", "R");
            put("...", "S");
            put("-", "T");
            put("..-", "U");
            put("...-", "V");
            put(".--", "W");
            put("-..-", "X");
            put("-.--", "Y");
            put("--..", "Z");
            put("-----", "0");
            put(".----", "1");
            put("..---", "2");
            put("...--", "3");
            put("....-", "4");
            put(".....", "5");
            put("-....", "6");
            put("--...", "7");
            put("---..", "8");
            put("----.", "9");
            put(".-.-.-", ".");
            put("--..--", ",");
            put("..--..", "?");
            put("-.-.--", "!");
            put("-....-", "-");
            put(".----.", "'");
            put("-..-.", "/");
            put("-.--.", "(");
            put("-.--.-", ")");
            put(".-.-.", "+");
            put("-...-", "=");
            put(".-..-.", "\"");
            put("...-..-", "$");
            put(".--.-.", "@");
        }};
        List<String> traducido = new ArrayList<>();
        Arrays.stream(codigo.split(" ")).forEach(p -> {
            System.out.println(morseToTexto.get(p));
            traducido.add(morseToTexto.get(p));
        });

        return traducido.stream().collect(Collectors.joining(""));
    }

    public List<String> separarPalabras(String codigo) {
        List<String> palabrasTraducidas = new ArrayList<>();
        if (codigo.contains("   ")) {
            String[] palabras = codigo.split("   ");
            Arrays.stream(palabras).forEach(p -> {
                palabrasTraducidas.add(traducir(p));
            });
            return palabrasTraducidas;
        }
        palabrasTraducidas.add(traducir(codigo));
        return palabrasTraducidas;
    }
}
