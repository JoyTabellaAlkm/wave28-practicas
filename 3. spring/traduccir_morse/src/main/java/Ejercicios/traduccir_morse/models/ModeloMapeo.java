package Ejercicios.traduccir_morse.models;

import java.util.HashMap;
import java.util.Map;

public class ModeloMapeo {

    private static final Map<String, Character> morseLetraMap;
    private static final Map<Character, String> oracionCodeMap;

    static {
        morseLetraMap = new HashMap<>();
        morseLetraMap.put(".-", 'A');
        morseLetraMap.put("-...", 'B');
        morseLetraMap.put("-.-.", 'C');
        morseLetraMap.put("-..", 'D');
        morseLetraMap.put(".", 'E');
        morseLetraMap.put("..-.", 'F');
        morseLetraMap.put("--.", 'G');
        morseLetraMap.put("....", 'H');
        morseLetraMap.put("..", 'I');
        morseLetraMap.put(".---", 'J');
        morseLetraMap.put("-.-", 'K');
        morseLetraMap.put(".-..", 'L');
        morseLetraMap.put("--", 'M');
        morseLetraMap.put("-.", 'N');
        morseLetraMap.put("---", 'O');
        morseLetraMap.put(".--.", 'P');
        morseLetraMap.put("--.-", 'Q');
        morseLetraMap.put(".-.", 'R');
        morseLetraMap.put("...", 'S');
        morseLetraMap.put("-", 'T');
        morseLetraMap.put("..-", 'U');
        morseLetraMap.put("...-", 'V');
        morseLetraMap.put(".--", 'W');
        morseLetraMap.put("-..-", 'X');
        morseLetraMap.put("-.--", 'Y');
        morseLetraMap.put("--..", 'Z');
        morseLetraMap.put(".----", '1');
        morseLetraMap.put("..---", '2');
        morseLetraMap.put("...--", '3');
        morseLetraMap.put("....-", '4');
        morseLetraMap.put(".....", '5');
        morseLetraMap.put("-....", '6');
        morseLetraMap.put("--...", '7');
        morseLetraMap.put("---..", '8');
        morseLetraMap.put("----.", '9');
        morseLetraMap.put("-----", '0');

        oracionCodeMap = new HashMap<>();
        oracionCodeMap.put('A', ".-");
        oracionCodeMap.put('B', "-...");
        oracionCodeMap.put('C', "-.-.");
        oracionCodeMap.put('D', "-..");
        oracionCodeMap.put('E', ".");
        oracionCodeMap.put('F', "..-.");
        oracionCodeMap.put('G', "--.");
        oracionCodeMap.put('H', "....");
        oracionCodeMap.put('I', "..");
        oracionCodeMap.put('J', ".---");
        oracionCodeMap.put('K', "-.-");
        oracionCodeMap.put('L', ".-..");
        oracionCodeMap.put('M', "--");
        oracionCodeMap.put('N', "-.");
        oracionCodeMap.put('O', "---");
        oracionCodeMap.put('P', ".--.");
        oracionCodeMap.put('Q', "--.-");
        oracionCodeMap.put('R', ".-.");
        oracionCodeMap.put('S', "...");
        oracionCodeMap.put('T', "-");
        oracionCodeMap.put('U', "..-");
        oracionCodeMap.put('V', "...-");
        oracionCodeMap.put('W', ".--");
        oracionCodeMap.put('X', "-..-");
        oracionCodeMap.put('Y', "-.--");
        oracionCodeMap.put('Z', "--..");
        oracionCodeMap.put('1', ".----");
        oracionCodeMap.put('2', "..---");
        oracionCodeMap.put('3', "...--");
        oracionCodeMap.put('4', "....-");
        oracionCodeMap.put('5', ".....");
        oracionCodeMap.put('6', "-....");
        oracionCodeMap.put('7', "--...");
        oracionCodeMap.put('8', "---..");
        oracionCodeMap.put('9', "----.");
        oracionCodeMap.put('0', "-----");
        oracionCodeMap.put(' ', " "); // Espacio
    }

    public static Map<String, Character> getMorseLetraMap() {
        return morseLetraMap;
    }

    public static Map<Character, String> getOracionCodeMap() {
        return oracionCodeMap;
    }
}