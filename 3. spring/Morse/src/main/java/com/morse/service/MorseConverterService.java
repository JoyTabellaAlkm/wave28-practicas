package com.morse.service;

import java.util.HashMap;
import java.util.Map;

public class MorseConverterService {

    public static final Map<String, String> invertedMorseCodeValues = new HashMap<>();
    static {
        invertedMorseCodeValues.put(".-", "A");
        invertedMorseCodeValues.put("-...", "B");
        invertedMorseCodeValues.put("-.-.", "C");
        invertedMorseCodeValues.put("-..", "D");
        invertedMorseCodeValues.put(".", "E");
        invertedMorseCodeValues.put("..-.", "F");
        invertedMorseCodeValues.put("--.", "G");
        invertedMorseCodeValues.put("....", "H");
        invertedMorseCodeValues.put("..", "I");
        invertedMorseCodeValues.put(".---", "J");
        invertedMorseCodeValues.put("-.-", "K");
        invertedMorseCodeValues.put(".-..", "L");
        invertedMorseCodeValues.put("--", "M");
        invertedMorseCodeValues.put("-.", "N");
        invertedMorseCodeValues.put("---", "O");
        invertedMorseCodeValues.put(".--.", "P");
        invertedMorseCodeValues.put("--.-", "Q");
        invertedMorseCodeValues.put(".-.", "R");
        invertedMorseCodeValues.put("...", "S");
        invertedMorseCodeValues.put("-", "T");
        invertedMorseCodeValues.put("..-", "U");
        invertedMorseCodeValues.put("...-", "V");
        invertedMorseCodeValues.put(".--", "W");
        invertedMorseCodeValues.put("-..-", "X");
        invertedMorseCodeValues.put("-.--", "Y");
        invertedMorseCodeValues.put("--..", "Z");
        invertedMorseCodeValues.put(".----", "1");
        invertedMorseCodeValues.put("..---", "2");
        invertedMorseCodeValues.put("...--", "3");
        invertedMorseCodeValues.put("....-", "4");
        invertedMorseCodeValues.put(".....", "5");
        invertedMorseCodeValues.put("-....", "6");
        invertedMorseCodeValues.put("--...", "7");
        invertedMorseCodeValues.put("---..", "8");
        invertedMorseCodeValues.put("----.", "9");
        invertedMorseCodeValues.put("-----", "0");
        invertedMorseCodeValues.put(".-.-.-", ".");
        invertedMorseCodeValues.put("--..--", ",");
        invertedMorseCodeValues.put("..--..", "?");
        invertedMorseCodeValues.put("-.-.--", "!");
    }

    public static String convertMorseToWord(String morse) {
        String word = "";
        String[] morseWords = morse.split("   ");

        for (String morseWord: morseWords) {
            String[] morseWordLetters = morseWord.split(" ");
            for (String morseWordLetter: morseWordLetters) {
                word += invertedMorseCodeValues.get(morseWordLetter);
            }
            word += " ";
        }

        return word.trim();
    }

}