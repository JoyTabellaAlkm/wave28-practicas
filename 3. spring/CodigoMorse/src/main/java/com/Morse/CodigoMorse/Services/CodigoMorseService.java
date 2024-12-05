package com.Morse.CodigoMorse.Services;

import java.util.HashMap;
import java.util.Map;

public final class CodigoMorseService {
    private static final Map<String, String> mapa = obtenerMapa();

    public static String traducirDesdeMorse(String texto) {
        StringBuilder traduccion = new StringBuilder();

        String[] palabras = texto.split("   ");
        for(String pal : palabras){
            String[] caracteres = pal.split(" ");
            for(String car : caracteres) {
                String valor = mapa.get(car);
                if(valor == null) {
                    return "Valor no encontrado";
                }
                else {
                    traduccion.append(mapa.get(car));
                }
            }
            traduccion.append(" ");
        }

        return traduccion.toString();
    }

    public static String traducirHaciaMorse(String textoNormal) {
        StringBuilder traduccion = new StringBuilder();

        String[] palabras = textoNormal.split(" ");
        for(String pal : palabras){
            String[] caracteres = pal.split("");
            for(String car : caracteres) {
                String valor = obtenerValor(car);
                traduccion.append(valor);
                traduccion.append("   ");
            }
            traduccion.append(" ");
        }

        return traduccion.toString();
    }

    private static String obtenerValor(String car){
        String valor = "";
        Map<String, String> morseCodeMap = obtenerMapa();
        for (Map.Entry<String, String> entry : morseCodeMap.entrySet()) {
            if (entry.getValue().equals(car)) {
                valor =  entry.getKey();
            }
        }
        return valor;
    }

    private static Map<String, String> obtenerMapa() {
        Map<String, String> morseCodeMap = new HashMap<>();
        morseCodeMap.put(".-", "A");
        morseCodeMap.put("-...", "B");
        morseCodeMap.put("-.-.", "C");
        morseCodeMap.put("-..", "D");
        morseCodeMap.put(".", "E");
        morseCodeMap.put("..-.", "F");
        morseCodeMap.put("--.", "G");
        morseCodeMap.put("....", "H");
        morseCodeMap.put("..", "I");
        morseCodeMap.put(".---", "J");
        morseCodeMap.put("-.-", "K");
        morseCodeMap.put(".-..", "L");
        morseCodeMap.put("--", "M");
        morseCodeMap.put("-.", "N");
        morseCodeMap.put("---", "O");
        morseCodeMap.put(".--.", "P");
        morseCodeMap.put("--.-", "Q");
        morseCodeMap.put(".-.", "R");
        morseCodeMap.put("...", "S");
        morseCodeMap.put("-", "T");
        morseCodeMap.put("..-", "U");
        morseCodeMap.put("...-", "V");
        morseCodeMap.put(".--", "W");
        morseCodeMap.put("-..-", "X");
        morseCodeMap.put("-.--", "Y");
        morseCodeMap.put("--..", "Z");

        // Números en código morse
        morseCodeMap.put(".----", "1");
        morseCodeMap.put("..---", "2");
        morseCodeMap.put("...--", "3");
        morseCodeMap.put("....-", "4");
        morseCodeMap.put(".....", "5");
        morseCodeMap.put("-....", "6");
        morseCodeMap.put("--...", "7");
        morseCodeMap.put("---..", "8");
        morseCodeMap.put("----.", "9");
        morseCodeMap.put("-----", "0");

        // Signos de puntuación en código morse
        morseCodeMap.put(".-.-.-", ".");
        morseCodeMap.put("--..--", ",");
        morseCodeMap.put("..--..", "?");
        morseCodeMap.put("-.-.--", "!");
        morseCodeMap.put("---...", ":");
        morseCodeMap.put("-.-.-.", ";");
        morseCodeMap.put("-.--.", "(");
        morseCodeMap.put("-.--.-", ")");
        morseCodeMap.put(".-..-.", "\"");
        morseCodeMap.put(".----.", "'");
        morseCodeMap.put("-....-", "-");
        morseCodeMap.put("..--.-", "_");
        morseCodeMap.put("-..-.", "/");
        morseCodeMap.put(".-.-.", "+");
        morseCodeMap.put(".-...", "&");
        morseCodeMap.put("/", " ");

        return morseCodeMap;
    }
}