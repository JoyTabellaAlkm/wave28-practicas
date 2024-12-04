package com.mercadolibre.morse_code.services;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MorseCodeParseService {

    private static Map<String, Character> morseToLetterMap = new HashMap<String, Character>() {{
        put(".-", 'A');
        put("-...", 'B');
        put("-.-.", 'C');
        put("-..", 'D');
        put(".", 'E');
        put("..-.", 'F');
        put("--.", 'G');
        put("....", 'H');
        put("..", 'I');
        put(".---", 'J');
        put("-.-", 'K');
        put(".-..", 'L');
        put("--", 'M');
        put("-.", 'N');
        put("---", 'O');
        put(".--.", 'P');
        put("--.-", 'Q');
        put(".-.", 'R');
        put("...", 'S');
        put("-", 'T');
        put("..-", 'U');
        put("...-", 'V');
        put(".--", 'W');
        put("-..-", 'X');
        put("-.--", 'Y');
        put("--..", 'Z');
        put(".----", '1');
        put("..---", '2');
        put("...--", '3');
        put("....-", '4');
        put(".....", '5');
        put("-....", '6');
        put("--...", '7');
        put("---..", '8');
        put("----.", '9');
        put("-----", '0');
        put("..--..", '?');
        put("-.-.--", '!');
        put(".-.-.-", '.');
        put("--..--", ',');
    }};


    public String parseMorseToText(String morse) {
        if (morse.isEmpty()) {
            return "";
        }
        String[] morseWords = morse.split("\\s{3}");
        List<String> morseWordsParsed = Arrays.stream(morseWords).map(word -> {
            StringBuilder sb = new StringBuilder();
            Arrays.stream(word.split("\\s")).map(morseToLetterMap::get).forEach(sb::append);
            return sb.toString();
        }).toList();
        return String.join(" ", morseWordsParsed);
    }
}
