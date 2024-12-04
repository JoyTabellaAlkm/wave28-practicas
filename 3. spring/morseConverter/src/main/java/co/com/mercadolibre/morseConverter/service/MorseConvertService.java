package co.com.mercadolibre.morseConverter.service;

import co.com.mercadolibre.morseConverter.model.Morse;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class MorseConvertService {

    private final Map<String, Character> morseCodeMap = new LinkedHashMap<>();

    public String convertToWords(Morse morse){
        fillMap();
        String code = morse.getCode();
        char[] charArray = code.toCharArray();
        String morseWord = "";
        String letter = "";
        String word = "";

        for (char character: charArray) {
            if (character != ' '){
                morseWord += character;
            } else {
                    letter += morseCodeMap.get(morseWord);
                    word += letter;
                    morseWord = "";
            }
        }
        return word;

    }

    private void fillMap(){
        morseCodeMap.put(".-", 'A');
        morseCodeMap.put("-...", 'B');
        morseCodeMap.put("-.-.", 'C');
        morseCodeMap.put("-..", 'D');
        morseCodeMap.put(".", 'E');
        morseCodeMap.put("..-.", 'F');
        morseCodeMap.put("--.", 'G');
        morseCodeMap.put("....", 'H');
        morseCodeMap.put("..", 'I');
        morseCodeMap.put(".---", 'J');
        morseCodeMap.put("-.-", 'K');
        morseCodeMap.put(".-..", 'L');
        morseCodeMap.put("--", 'M');
        morseCodeMap.put("-.", 'N');
        morseCodeMap.put("---", 'O');
        morseCodeMap.put(".--.", 'P');
        morseCodeMap.put("--.-", 'Q');
        morseCodeMap.put(".-.", 'R');
        morseCodeMap.put("...", 'S');
        morseCodeMap.put("-", 'T');
        morseCodeMap.put("..-", 'U');
        morseCodeMap.put("...-", 'V');
        morseCodeMap.put(".--", 'W');
        morseCodeMap.put("-..-", 'X');
        morseCodeMap.put("-.--", 'Y');
        morseCodeMap.put("--..", 'Z');
        morseCodeMap.put(".----", '1');
        morseCodeMap.put("..---", '2');
        morseCodeMap.put("...--", '3');
        morseCodeMap.put("....-", '4');
        morseCodeMap.put(".....", '5');
        morseCodeMap.put("-....", '6');
        morseCodeMap.put("--...", '7');
        morseCodeMap.put("---..", '8');
        morseCodeMap.put("----.", '9');
        morseCodeMap.put("-----", '0');
        morseCodeMap.put(" ", ' ');

    }



}
