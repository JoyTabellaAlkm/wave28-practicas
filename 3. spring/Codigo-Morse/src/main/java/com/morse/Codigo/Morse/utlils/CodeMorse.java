package com.morse.Codigo.Morse.utlils;

import java.util.HashMap;
import java.util.Map;

public class CodeMorse {
    public static final HashMap<String, String> MORSE_A_TEXTO = new HashMap<>();
    static {
        MORSE_A_TEXTO.put(".-", "A");
        MORSE_A_TEXTO.put("-...", "B");
        MORSE_A_TEXTO.put("-.-.", "C");
        MORSE_A_TEXTO.put("-..", "D");
        MORSE_A_TEXTO.put(".", "E");
        MORSE_A_TEXTO.put("..-.", "F");
        MORSE_A_TEXTO.put("--.", "G");
        MORSE_A_TEXTO.put("....", "H");
        MORSE_A_TEXTO.put("..", "I");
        MORSE_A_TEXTO.put(".---", "J");
        MORSE_A_TEXTO.put("-.-", "K");
        MORSE_A_TEXTO.put(".-..", "L");
        MORSE_A_TEXTO.put("--", "M");
        MORSE_A_TEXTO.put("-.", "N");
        MORSE_A_TEXTO.put("---", "O");
        MORSE_A_TEXTO.put(".--.", "P");
        MORSE_A_TEXTO.put("--.-", "Q");
        MORSE_A_TEXTO.put(".-.", "R");
        MORSE_A_TEXTO.put("...", "S");
        MORSE_A_TEXTO.put("-", "T");
        MORSE_A_TEXTO.put("..-", "U");
        MORSE_A_TEXTO.put("...-", "V");
        MORSE_A_TEXTO.put(".--", "W");
        MORSE_A_TEXTO.put("-..-", "X");
        MORSE_A_TEXTO.put("-.--", "Y");
        MORSE_A_TEXTO.put("--..", "Z");
        MORSE_A_TEXTO.put("-----", "0");
        MORSE_A_TEXTO.put(".----", "1");
        MORSE_A_TEXTO.put("..---", "2");
        MORSE_A_TEXTO.put("...--", "3");
        MORSE_A_TEXTO.put("....-", "4");
        MORSE_A_TEXTO.put(".....", "5");
        MORSE_A_TEXTO.put("-....", "6");
        MORSE_A_TEXTO.put("--...", "7");
        MORSE_A_TEXTO.put("---..", "8");
        MORSE_A_TEXTO.put("----.", "9");
    }


    public static final HashMap<String, String> TEXTO_A_MORSE = new HashMap<>();
    static {
        TEXTO_A_MORSE.put("A", ".-");
        TEXTO_A_MORSE.put("B", "-...");
        TEXTO_A_MORSE.put("C", "-.-.");
        TEXTO_A_MORSE.put("D", "-..");
        TEXTO_A_MORSE.put("E", ".");
        TEXTO_A_MORSE.put("F", "..-.");
        TEXTO_A_MORSE.put("G", "--.");
        TEXTO_A_MORSE.put("H", "....");
        TEXTO_A_MORSE.put("I", "..");
        TEXTO_A_MORSE.put("J", ".---");
        TEXTO_A_MORSE.put("K", "-.-");
        TEXTO_A_MORSE.put("L", ".-..");
        TEXTO_A_MORSE.put("M", "--");
        TEXTO_A_MORSE.put("N", "-.");
        TEXTO_A_MORSE.put("O", "---");
        TEXTO_A_MORSE.put("P", ".--.");
        TEXTO_A_MORSE.put("Q", "--.-");
        TEXTO_A_MORSE.put("R", ".-.");
        TEXTO_A_MORSE.put("S", "...");
        TEXTO_A_MORSE.put("T", "-");
        TEXTO_A_MORSE.put("U", "..-");
        TEXTO_A_MORSE.put("V", "...-");
        TEXTO_A_MORSE.put("W", ".--");
        TEXTO_A_MORSE.put("X", "-..-");
        TEXTO_A_MORSE.put("Y", "-.--");
        TEXTO_A_MORSE.put("Z", "--..");
        TEXTO_A_MORSE.put("0", "-----");
        TEXTO_A_MORSE.put("1", ".----");
        TEXTO_A_MORSE.put("2", "..---");
        TEXTO_A_MORSE.put("3", "...--");
        TEXTO_A_MORSE.put("4", "....-");
        TEXTO_A_MORSE.put("5", ".....");
        TEXTO_A_MORSE.put("6", "-....");
        TEXTO_A_MORSE.put("7", "--...");
        TEXTO_A_MORSE.put("8", "---..");
        TEXTO_A_MORSE.put("9", "----.");
    }
}
