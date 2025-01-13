package com.codigomorse.MorseCode.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvertService {
    public static final Map<String, String> morseCodeValues = new HashMap<>();
    public static final Map<String, String> invertedMorseCodeValues = new HashMap<>();

    static {
        morseCodeValues.put("A", ".-");
        morseCodeValues.put("B", "-...");
        morseCodeValues.put("C", "-.-.");
        morseCodeValues.put("D", "-..");
        morseCodeValues.put("E", ".");
        morseCodeValues.put("F", "..-.");
        morseCodeValues.put("G", "--.");
        morseCodeValues.put("H", "....");
        morseCodeValues.put("I", "..");
        morseCodeValues.put("J", ".---");
        morseCodeValues.put("K", "-.-");
        morseCodeValues.put("L", ".-..");
        morseCodeValues.put("M", "--");
        morseCodeValues.put("N", "-.");
        morseCodeValues.put("O", "---");
        morseCodeValues.put("P", ".--.");
        morseCodeValues.put("Q", "--.-");
        morseCodeValues.put("R", ".-.");
        morseCodeValues.put("S", "...");
        morseCodeValues.put("T", "-");
        morseCodeValues.put("U", "..-");
        morseCodeValues.put("V", "...-");
        morseCodeValues.put("W", ".--");
        morseCodeValues.put("X", "-..-");
        morseCodeValues.put("Y", "-.--");
        morseCodeValues.put("Z", "--..");
        morseCodeValues.put("1", ".----");
        morseCodeValues.put("2", "..---");
        morseCodeValues.put("3", "...--");
        morseCodeValues.put("4", "....-");
        morseCodeValues.put("5", ".....");
        morseCodeValues.put("6", "-....");
        morseCodeValues.put("7", "--...");
        morseCodeValues.put("8", "---..");
        morseCodeValues.put("9", "----.");
        morseCodeValues.put("0", "-----");
        morseCodeValues.put(".", ".-.-.-");
        morseCodeValues.put(",", "--..--");
        morseCodeValues.put("?", "..--..");
        morseCodeValues.put("!", "-.-.--");

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

        return Arrays.stream(morseWords)
                .map(morseWord -> {
                    return Arrays.stream(morseWord.split(" "))
                            .map(invertedMorseCodeValues::get)
                            .collect(Collectors.joining());
                }).collect(Collectors.joining(" "));
    }
}
