package com.example.demo.service;

import com.example.demo.model.Morse_model;

import java.util.Arrays;

public class Morse_service {
    Morse_model morse_model = new Morse_model();

    public String to_morse(String t){
        if( t.isEmpty() ) return "";

        String morse = "";
        String[] words = t.trim().split(" ");
        if( words.length == 0 ) return "";
        boolean ok = false;
        for(String w : words){
            String w_morse = "";
            for(int i = 0; i < w.length(); ++i){
                w_morse += morse_model.getString_Morse().get(w.charAt(i));
            }
            morse += (ok ? " " : "") + w_morse;
            ok = true;
        }
        return morse;
    }

    public String to_word(String t){
        System.out.println(t);
        if( t.isEmpty() ) return "";

        String[] words = t.trim().split(" {3}");
        if( words.length == 0 ) return "";
        StringBuilder word = new StringBuilder();
        Arrays.stream(words).forEach(palabra ->{
            String[] letras = palabra.split(" ");
            Arrays.stream(letras).forEach(letra -> {
                word.append(morse_model.getMorse_String().getOrDefault(letra, ' '));
            });
            word.append(" ");
        });
        return word.toString();
    }
}
