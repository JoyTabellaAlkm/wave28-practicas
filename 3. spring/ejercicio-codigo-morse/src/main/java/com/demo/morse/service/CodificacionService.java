package com.demo.morse.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class CodificacionService {
    private static final Map<String, Character> MORSE_TO_CHAR = new HashMap<>();
    private static final Map<Character, String> CHAR_TO_MORSE = new HashMap<>();

    static {
        MORSE_TO_CHAR.put(".-", 'A');
        MORSE_TO_CHAR.put("-...", 'B');
        MORSE_TO_CHAR.put("-.-.", 'C');
        MORSE_TO_CHAR.put("-..", 'D');
        MORSE_TO_CHAR.put(".", 'E');
        MORSE_TO_CHAR.put("..-.", 'F');
        MORSE_TO_CHAR.put("--.", 'G');
        MORSE_TO_CHAR.put("....", 'H');
        MORSE_TO_CHAR.put("..", 'I');
        MORSE_TO_CHAR.put(".---", 'J');
        MORSE_TO_CHAR.put("-.-", 'K');
        MORSE_TO_CHAR.put(".-..", 'L');
        MORSE_TO_CHAR.put("--", 'M');
        MORSE_TO_CHAR.put("-.", 'N');
        MORSE_TO_CHAR.put("---", 'O');
        MORSE_TO_CHAR.put(".--.", 'P');
        MORSE_TO_CHAR.put("--.-", 'Q');
        MORSE_TO_CHAR.put(".-.", 'R');
        MORSE_TO_CHAR.put("...", 'S');
        MORSE_TO_CHAR.put("-", 'T');
        MORSE_TO_CHAR.put("..-", 'U');
        MORSE_TO_CHAR.put("...-", 'V');
        MORSE_TO_CHAR.put(".--", 'W');
        MORSE_TO_CHAR.put("-..-", 'X');
        MORSE_TO_CHAR.put("-.--", 'Y');
        MORSE_TO_CHAR.put("--..", 'Z');
        MORSE_TO_CHAR.put("-----", '0');
        MORSE_TO_CHAR.put(".----", '1');
        MORSE_TO_CHAR.put("..---", '2');
        MORSE_TO_CHAR.put("...--", '3');
        MORSE_TO_CHAR.put("....-", '4');
        MORSE_TO_CHAR.put(".....", '5');
        MORSE_TO_CHAR.put("-....", '6');
        MORSE_TO_CHAR.put("--...", '7');
        MORSE_TO_CHAR.put("---..", '8');
        MORSE_TO_CHAR.put("----.", '9');
        MORSE_TO_CHAR.put("..--..", '?');
        MORSE_TO_CHAR.put("-.-.--", '!');
        MORSE_TO_CHAR.put(".-.-.-", '.');
        MORSE_TO_CHAR.put("--..--", ',');
        MORSE_TO_CHAR.forEach((key, value) -> CHAR_TO_MORSE.put(value, key));
    }

    public static String decodificar(String codigo){
        StringBuilder fraseDecodificada = new StringBuilder();
        String[] palabras = codigo.split(" {3}");
        for (String palabra : palabras){
            String[] letras = palabra.split(" ");
            fraseDecodificada.append(Arrays.stream(letras).map(x -> MORSE_TO_CHAR.get(x).toString()).collect(Collectors.joining()));
            fraseDecodificada.append(" ");
        }
        return fraseDecodificada.toString();
    }

    public static String codificar(String frase){
        frase = frase.toUpperCase();
        StringBuilder fraseCodificada = new StringBuilder();
        String[] palabras = frase.split(" ");
        for (String palabra : palabras){
            String[] caracteres = palabra.split("");
            fraseCodificada.append(Arrays.stream(caracteres).map(x -> CHAR_TO_MORSE.get(x.charAt(0))).collect(Collectors.joining(" ")));
            fraseCodificada.append("   ");
        }
        System.out.println(fraseCodificada);
        return fraseCodificada.toString();
    }

}
