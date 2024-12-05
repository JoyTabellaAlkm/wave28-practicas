package co.mercadolibre.morse.service;

import co.mercadolibre.morse.model.MorseCode;

import java.util.Arrays;

public class MorseService {
    MorseCode mc = new MorseCode();

    public String stringToMorse(String text){
        if (text.isEmpty()) return "";
        StringBuilder morse = new StringBuilder();

        String[] palabras = text.trim().split(" ");
        if(palabras.length == 0) return "";

        Arrays.stream(palabras).forEach(palabra ->{
                String[] letras = palabra.split("");
                Arrays.stream(letras).forEach(letra -> {
                    morse.append(mc.getStringToMorse().getOrDefault(letra.toLowerCase().charAt(0), " ")).append(" ");
                });
                morse.append("   ");
        });
        return morse.toString();
    }

    public String morseToString(String morse){
        if (morse.isEmpty()) return "";
        StringBuilder text = new StringBuilder();

        String[] palabras = morse.trim().split(" {3}");
        if(palabras.length == 0) return "";

        Arrays.stream(palabras).forEach(palabra ->{
            String[] letras = palabra.split(" ");
            Arrays.stream(letras).forEach(letra -> {
                text.append(mc.getMorseToString().getOrDefault(letra, ' '));
            });
            text.append(" ");
        });
        return text.toString();
    }
}