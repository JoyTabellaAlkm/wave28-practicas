import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
// faltaría dividirlo bien en service y controller, está mal que la logica esté metida acá adentro
@RestController
@RequestMapping("/demo")
public class CodigoMorseController {
    @GetMapping("/morse")
    public String Tarea(@RequestParam String oracion){
        Map<String, Character> morseToChar = new HashMap<>();
        morseToChar.put(".-", 'A');
        morseToChar.put("-...", 'B');
        morseToChar.put("-.-.", 'C');
        morseToChar.put("-..", 'D');
        morseToChar.put(".", 'E');
        morseToChar.put("..-.", 'F');
        morseToChar.put("--.", 'G');
        morseToChar.put("....", 'H');
        morseToChar.put("..", 'I');
        morseToChar.put(".---", 'J');
        morseToChar.put("-.-", 'K');
        morseToChar.put(".-..", 'L');
        morseToChar.put("--", 'M');
        morseToChar.put("-.", 'N');
        morseToChar.put("---", 'O');
        morseToChar.put(".--.", 'P');
        morseToChar.put("--.-", 'Q');
        morseToChar.put(".-.", 'R');
        morseToChar.put("...", 'S');
        morseToChar.put("-", 'T');
        morseToChar.put("..-", 'U');
        morseToChar.put("...-", 'V');
        morseToChar.put(".--", 'W');
        morseToChar.put("-..-", 'X');
        morseToChar.put("-.--", 'Y');
        morseToChar.put("--..", 'Z');
        morseToChar.put("-----", '0');
        morseToChar.put(".----", '1');
        morseToChar.put("..---", '2');
        morseToChar.put("...--", '3');
        morseToChar.put("....-", '4');
        morseToChar.put(".....", '5');
        morseToChar.put("-....", '6');
        morseToChar.put("--...", '7');
        morseToChar.put("---..", '8');
        morseToChar.put("----.", '9');
        String resultado= decodeMorsePhrase(oracion, morseToChar);
        System.out.println(resultado);
        return resultado;
    }
    public static String decodeMorsePhrase(String oracion, Map<String, Character> morseToChar) {
        String[] morseWords = oracion.split("");
        String decodedPhrase = "";
        for (String morseWord : morseWords) {
            String[] morseChars = morseWord.split(" ");
            String decodedWord = "";
            for (String morseChar : morseChars) {
                Character decodedChar = morseToChar.get(morseChar);
                if (decodedChar != null) {
                    decodedWord += decodedChar;                }
            }
            decodedPhrase += decodedWord + " ";
        }
        return decodedPhrase.trim().toUpperCase();
    }
}