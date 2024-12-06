package com.example.demo.model;


import java.util.HashMap;
import java.util.Map;


public class Morse_model {

    private HashMap<String, Character> morse_string;
    private HashMap<Character, String> string_morse;

    public Morse_model() {
        morse_string = new HashMap<>();
        string_morse = new HashMap<>();
        fill_morse();
        fill_string();
    }

    public void fill_morse(){
        morse_string.put(".-", 'a');
        morse_string.put("-...", 'b');
        morse_string.put("-.-.", 'c');
        morse_string.put("-..", 'd');
        morse_string.put(".", 'e');
        morse_string.put("..-.", 'f');
        morse_string.put("--.", 'g');
        morse_string.put("....", 'h');
        morse_string.put("..", 'i');
        morse_string.put(".---", 'j');
        morse_string.put("-.", 'k');
        morse_string.put(".-..", 'l');
        morse_string.put("--", 'm');
        morse_string.put("-.", 'n');
        morse_string.put("---", 'o');
        morse_string.put(".--.", 'p');
        morse_string.put("--.-", 'q');
        morse_string.put(".-.", 'r');
        morse_string.put("...", 's');
        morse_string.put("-", 't');
        morse_string.put("..-", 'u');
        morse_string.put("...-", 'v');
        morse_string.put(".--", 'w');
        morse_string.put("-..-", 'x');
        morse_string.put("-.--", 'y');
        morse_string.put("--..", 'z');
        morse_string.put(".----", '1');
        morse_string.put("..---", '2');
        morse_string.put("...--", '3');
        morse_string.put("....-", '4');
        morse_string.put(".....", '5');
        morse_string.put("-....", '6');
        morse_string.put("--...", '7');
        morse_string.put("---..", '8');
        morse_string.put("----.", '9');
        morse_string.put("-----", '0');
    }

    public void fill_string(){
        string_morse.put('a', ".-");
        string_morse.put('b', "-...");
        string_morse.put('c', "-.-.");
        string_morse.put('d', "-..");
        string_morse.put('e', ".");
        string_morse.put('f', "..-.");
        string_morse.put('g', "--.");
        string_morse.put('h', "....");
        string_morse.put('i', "..");
        string_morse.put('j', ".---");
        string_morse.put('k', "-.-");
        string_morse.put('l', ".-..");
        string_morse.put('m', "--");
        string_morse.put('n', "-.");
        string_morse.put('o', "---");
        string_morse.put('p', ".--.");
        string_morse.put('q', "--.-");
        string_morse.put('r', ".-.");
        string_morse.put('s', "...");
        string_morse.put('t', "-");
        string_morse.put('u', "..-");
        string_morse.put('v', "...-");
        string_morse.put('w', ".--");
        string_morse.put('x', "-..-");
        string_morse.put('y', "-.--");
        string_morse.put('z', "--..");
        string_morse.put('1', ".----");
        string_morse.put('2', "..---");
        string_morse.put('3', "...--");
        string_morse.put('4', "....-");
        string_morse.put('5', ".....");
        string_morse.put('6', "-....");
        string_morse.put('7', "--...");
        string_morse.put('8', "---..");
        string_morse.put('9', "----.");
        string_morse.put('0', "-----");
    }

    public Map<String, Character> getMorse_String(){
        return morse_string;
    }

    public Map<Character, String> getString_Morse(){
        return string_morse;
    }
}