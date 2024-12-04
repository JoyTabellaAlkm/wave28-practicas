package com.morseExercise.morseTranslatorApi.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MorseTranslatorServiceImpl implements IMorseTranslatorService{
    @Override
    public List<String> split(String encodedMorse) {
        return List.of(encodedMorse.split(" "));
    }

    @Override
    public Character translateCharacter(String encodedMorseCharacter) {
        Map<String, Character> charactersMap = new HashMap<>();
        charactersMap.put(".-", 'A');
        charactersMap.put("-...", 'B');
        charactersMap.put("-.-.", 'C');
        charactersMap.put("-..", 'D');
        charactersMap.put(".", 'E');
        charactersMap.put("..-.", 'F');
        charactersMap.put("--.", 'G');
        charactersMap.put("....", 'H');
        charactersMap.put("..", 'I');
        charactersMap.put(".---", 'J');
        charactersMap.put("-.-", 'K');
        charactersMap.put(".-..", 'L');
        charactersMap.put("--", 'M');
        charactersMap.put("-.", 'N');
        charactersMap.put("---", 'O');
        charactersMap.put(".--.", 'P');
        charactersMap.put("--.-", 'Q');
        charactersMap.put(".-.", 'R');
        charactersMap.put("...", 'S');
        charactersMap.put("-", 'T');
        charactersMap.put("..-", 'U');
        charactersMap.put("...-", 'V');
        charactersMap.put(".--", 'W');
        charactersMap.put("-..-", 'X');
        charactersMap.put("-.--", 'Y');
        charactersMap.put("--..", 'Z');
        charactersMap.put(".----", '0');
        charactersMap.put("..---", '1');
        charactersMap.put("...--", '2');
        charactersMap.put("....-", '3');
        charactersMap.put(".....", '4');
        charactersMap.put("-....", '5');
        charactersMap.put("--...", '6');
        charactersMap.put("---..", '7');
        charactersMap.put("----.", '8');
        charactersMap.put("-----", '9');
        charactersMap.put("-.-.--", '!');
        charactersMap.put("..--..", '?');
        charactersMap.put(".-.-.-", '.');
        charactersMap.put("--..--", ',');

        return charactersMap.get(encodedMorseCharacter);
    }

    public List<Character> translateWord(String encodedWord){
        List<String> encodedWordList = split(encodedWord);
        List<Character> translatedWord = new java.util.ArrayList<>(List.of());
        for(String encodedCharacter : encodedWordList){
            translatedWord.add(translateCharacter(encodedCharacter));
        }
        return translatedWord;
    }
}
