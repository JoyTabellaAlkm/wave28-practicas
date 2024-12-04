package com.example.codigomorse.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MorseCodeParseService {

    public String convertMorseCodeToText(String morse) {
        StringBuilder result = new StringBuilder();

        //Separar el codigo morse en palabras con if
        String wordMorse[] = morse.split(" {3}"); //queda para los dos

        for (String word : wordMorse){
            String letterMorse[] = word.split(" ");
            for (String letter:letterMorse){
                Character character = morseToLetterMap.get(letter);
                if(character != null){
                    result.append(character);
                }
            }
            result.append(" ");
        }

        return result.toString().trim();

        //Con stream
//        List<String> wordsParsed = Arrays.stream(wordMorse).map(word -> {
//            StringBuilder sb = new StringBuilder();
//            Arrays.stream(word.split(" "))
//                    .map(t -> morseToLetterMap.get(t)).forEach(letter -> {
//                        sb.append(letter);
//                    });
//            return sb.toString();
//        }).toList();
//
//        return String.join(" ",wordsParsed);
    }

    //Dato de Lucas: (?=^.{8,}$)((?=.*\d)|(?=.*\W+))(?![.\n])(?=.*[A-Z])(?=.*[a-z]).*$" Para validar texto

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
}

