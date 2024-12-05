package com.spring.ejercicios.services.impl;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CodigoMorseService {
    private static final Map<String, String> morseToLetterMap = new HashMap<>();
    static {
        morseToLetterMap.put(".-", "A");
        morseToLetterMap.put("-...", "B");
        morseToLetterMap.put("-.-.", "C");
        morseToLetterMap.put("-..", "D");
        morseToLetterMap.put(".", "E");
        morseToLetterMap.put("..-.", "F");
        morseToLetterMap.put("--.", "G");
        morseToLetterMap.put("....", "H");
        morseToLetterMap.put("..", "I");
        morseToLetterMap.put(".---", "J");
        morseToLetterMap.put("-.-", "K");
        morseToLetterMap.put(".-..", "L");
        morseToLetterMap.put("--", "M");
        morseToLetterMap.put("-.", "N");
        morseToLetterMap.put("---", "O");
        morseToLetterMap.put(".--.", "P");
        morseToLetterMap.put("--.-", "Q");
        morseToLetterMap.put(".-.", "R");
        morseToLetterMap.put("...", "S");
        morseToLetterMap.put("-", "T");
        morseToLetterMap.put("..-", "U");
        morseToLetterMap.put("...-", "V");
        morseToLetterMap.put(".--", "W");
        morseToLetterMap.put("-..-", "X");
        morseToLetterMap.put("-.--", "Y");
        morseToLetterMap.put("--..", "Z");
        morseToLetterMap.put("-----", "0");
        morseToLetterMap.put(".----", "1");
        morseToLetterMap.put("..---", "2");
        morseToLetterMap.put("...--", "3");
        morseToLetterMap.put("....-", "4");
        morseToLetterMap.put(".....", "5");
        morseToLetterMap.put("-....", "6");
        morseToLetterMap.put("--...", "7");
        morseToLetterMap.put("---..", "8");
        morseToLetterMap.put("----.", "9");
    }

    public String convertirMorseATexto(String morse) {

        String[] palabrasEnMorse = morse.split("   ");
        StringBuilder textoCompleto = new StringBuilder();

        for( String palabraEnMorse : palabrasEnMorse ) {

            StringBuilder palabra = new StringBuilder();

            String[] simboloMorse = palabraEnMorse.split(" ");

            for( String simbolo : simboloMorse ) {
                String letra = morseToLetterMap.get(simbolo);

                if(letra != null) {
                    palabra.append(letra);
                }

            }

            textoCompleto.append(palabra).append(" ");

        }

        return textoCompleto.toString();

    }
}
