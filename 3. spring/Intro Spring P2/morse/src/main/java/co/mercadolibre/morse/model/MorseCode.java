package co.mercadolibre.morse.model;

import java.util.HashMap;
import java.util.Map;

public class MorseCode {
    private HashMap<String, Character> morseToString;
    private HashMap<Character, String> stringToMorse;

    public MorseCode(){
        morseToString = new HashMap<>();
        stringToMorse = new HashMap<>();
        poblarMapaMorse();
        poblarMapaString();
    }

    public void poblarMapaMorse(){
        morseToString.put(".-", 'a');
        morseToString.put("-...", 'b');
        morseToString.put("-.-.", 'c');
        morseToString.put("-..", 'd');
        morseToString.put(".", 'e');
        morseToString.put("..-.", 'f');
        morseToString.put("--.", 'g');
        morseToString.put("....", 'h');
        morseToString.put("..", 'i');
        morseToString.put(".---", 'j');
        morseToString.put("-.", 'k');
        morseToString.put(".-..", 'l');
        morseToString.put("--", 'm');
        morseToString.put("-.", 'n');
        morseToString.put("---", 'o');
        morseToString.put(".--.", 'p');
        morseToString.put("--.-", 'q');
        morseToString.put(".-.", 'r');
        morseToString.put("...", 's');
        morseToString.put("-", 't');
        morseToString.put("..-", 'u');
        morseToString.put("...-", 'v');
        morseToString.put(".--", 'w');
        morseToString.put("-..-", 'x');
        morseToString.put("-.--", 'y');
        morseToString.put("--..", 'z');
        morseToString.put(".----", '1');
        morseToString.put("..---", '2');
        morseToString.put("...--", '3');
        morseToString.put("....-", '4');
        morseToString.put(".....", '5');
        morseToString.put("-....", '6');
        morseToString.put("--...", '7');
        morseToString.put("---..", '8');
        morseToString.put("----.", '9');
        morseToString.put("-----", '0');
    }

    public void poblarMapaString(){
        stringToMorse.put('a', ".-");
        stringToMorse.put('b', "-...");
        stringToMorse.put('c', "-.-.");
        stringToMorse.put('d', "-..");
        stringToMorse.put('e', ".");
        stringToMorse.put('f', "..-.");
        stringToMorse.put('g', "--.");
        stringToMorse.put('h', "....");
        stringToMorse.put('i', "..");
        stringToMorse.put('j', ".---");
        stringToMorse.put('k', "-.-");
        stringToMorse.put('l', ".-..");
        stringToMorse.put('m', "--");
        stringToMorse.put('n', "-.");
        stringToMorse.put('o', "---");
        stringToMorse.put('p', ".--.");
        stringToMorse.put('q', "--.-");
        stringToMorse.put('r', ".-.");
        stringToMorse.put('s', "...");
        stringToMorse.put('t', "-");
        stringToMorse.put('u', "..-");
        stringToMorse.put('v', "...-");
        stringToMorse.put('w', ".--");
        stringToMorse.put('x', "-..-");
        stringToMorse.put('y', "-.--");
        stringToMorse.put('z', "--..");
        stringToMorse.put('1', ".----");
        stringToMorse.put('2', "..---");
        stringToMorse.put('3', "...--");
        stringToMorse.put('4', "....-");
        stringToMorse.put('5', ".....");
        stringToMorse.put('6', "-....");
        stringToMorse.put('7', "--...");
        stringToMorse.put('8', "---..");
        stringToMorse.put('9', "----.");
        stringToMorse.put('0', "-----");
    }

    public Map<String, Character> getMorseToString() {
        return morseToString;
    }

    public Map<Character, String> getStringToMorse() {
        return stringToMorse;
    }
}
