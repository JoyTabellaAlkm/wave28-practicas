package com.example.demo.services;

import java.util.*;

public class MorseCode {
    public String code;
    public Map<String, String> dictionary = new HashMap<>();

    public MorseCode(String code){
        this.code = code;
        this.dictionary.put(".-", "a");
        this.dictionary.put("-...", "b");
        this.dictionary.put("-.-.", "c");
        this.dictionary.put("-..", "d");
        this.dictionary.put(".", "e");
        this.dictionary.put("..-.", "f");
        this.dictionary.put("--.", "g");
        this.dictionary.put("....", "h");
        this.dictionary.put("..", "i");
        this.dictionary.put(".---", "j");
        this.dictionary.put("-.-", "k");
        this.dictionary.put(".-..", "l");
        this.dictionary.put("--", "m");
        this.dictionary.put("-.", "n");
        this.dictionary.put("---", "o");
        this.dictionary.put(".--.", "p");
        this.dictionary.put("--.-", "q");
        this.dictionary.put("...", "s");
        this.dictionary.put(".-.", "r");
        this.dictionary.put("-", "t");
        this.dictionary.put("..-", "u");
        this.dictionary.put("...-", "v");
        this.dictionary.put(".--", "w");
        this.dictionary.put("-..-", "x");
        this.dictionary.put("-.--", "y");
        this.dictionary.put("--..", "z");
        this.dictionary.put(".----", "1");
        this.dictionary.put("..---", "2");
        this.dictionary.put("...--", "3");
        this.dictionary.put("....-", "4");
        this.dictionary.put(".....", "5");
        this.dictionary.put("..--..", "?");
        this.dictionary.put("-.-.--", "!");
    }

    public String convert(){
        String[] codeList = this.code.split(" ");
        String response = "";
        for (int i = 0; i < codeList.length; i++) {
            response += (codeList[i].isEmpty()) ? " " : this.dictionary.get(codeList[i]);
        }
        return response;
    }
}
