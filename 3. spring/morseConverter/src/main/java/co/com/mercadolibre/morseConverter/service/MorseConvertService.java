package co.com.mercadolibre.morseConverter.service;

import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class MorseConvertService {

    private final Map<String, Character> morseCode = new LinkedHashMap<>();

    public MorseConvertService() {
        fillMap();
    }

    public String convertToWords(String code) {
        StringBuilder stringBuilder = new StringBuilder();
        String[] words = code.split(" {3}");

        for (String word : words) {
            String[] characters = word.split(" ");
            for (String character : characters) {
                stringBuilder.append(morseCode.get(character));
            }
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();

    }

    private void fillMap() {
        morseCode.put(".-", 'A');
        morseCode.put("-...", 'B');
        morseCode.put("-.-.", 'C');
        morseCode.put("-..", 'D');
        morseCode.put(".", 'E');
        morseCode.put("..-.", 'F');
        morseCode.put("--.", 'G');
        morseCode.put("....", 'H');
        morseCode.put("..", 'I');
        morseCode.put(".---", 'J');
        morseCode.put("-.-", 'K');
        morseCode.put(".-..", 'L');
        morseCode.put("--", 'M');
        morseCode.put("-.", 'N');
        morseCode.put("---", 'O');
        morseCode.put(".--.", 'P');
        morseCode.put("--.-", 'Q');
        morseCode.put(".-.", 'R');
        morseCode.put("...", 'S');
        morseCode.put("-", 'T');
        morseCode.put("..-", 'U');
        morseCode.put("...-", 'V');
        morseCode.put(".--", 'W');
        morseCode.put("-..-", 'X');
        morseCode.put("-.--", 'Y');
        morseCode.put("--..", 'Z');
        morseCode.put(".----", '1');
        morseCode.put("..---", '2');
        morseCode.put("...--", '3');
        morseCode.put("....-", '4');
        morseCode.put(".....", '5');
        morseCode.put("-....", '6');
        morseCode.put("--...", '7');
        morseCode.put("---..", '8');
        morseCode.put("----.", '9');
        morseCode.put("-----", '0');

    }


}
