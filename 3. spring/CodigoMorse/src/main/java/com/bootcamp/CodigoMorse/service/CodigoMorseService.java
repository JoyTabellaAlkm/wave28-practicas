package com.bootcamp.CodigoMorse.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CodigoMorseService {
    Map<String, String> textoAMorse = new HashMap<>();
    Map<String, String> morseATexto = new HashMap<>() {{
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
        put("  ", " ");// Para agregar espacios entre palabras
    }};


    public String traducirMorseATexto (String textoMorse){

        String[] palabrasMorse = textoMorse.split("  ");//
        StringBuilder textoCompletoEsp = new StringBuilder();

        for (String palabraMorse : palabrasMorse){//
            String[] codigosMorse = palabraMorse.split(" ");
            StringBuilder palabra = new StringBuilder();

            for (String codigo : codigosMorse) {
                String letra = morseATexto.get(codigo);
                palabra.append(letra);
            }
            textoCompletoEsp.append(palabra).append(" ");

        }
        return textoCompletoEsp.toString();
    }

    public String traducirTextoAMorse (String textoEspañol){
        morseATexto.forEach((key,value) -> textoAMorse.put(value,key));

        String[] palabrasEsp = textoEspañol.split("");
        StringBuilder textoCompletoMor = new StringBuilder();

        for (String palabraEsp : palabrasEsp) {
            String[] palabras = palabraEsp.split(" ");
            StringBuilder palabraEs = new StringBuilder();

            for (String palabra : palabras) {
                String codigo = textoAMorse.get(palabra);
                palabraEs.append(codigo);
            }

            textoCompletoMor.append(palabraEs).append(" ");
        }
        return textoCompletoMor.toString();
    }

}
