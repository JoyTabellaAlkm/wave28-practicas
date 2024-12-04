package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
@RestController
@RequestMapping("/demo")
public class Controller {
    @GetMapping("/morseAOracion")
    public String morseAOracion(@RequestParam String oracion){
        Map<String, Character> morseAChar = new HashMap<>();
        morseAChar.put(".-", 'A');
        morseAChar.put("-...", 'B');
        morseAChar.put("-.-.", 'C');
        morseAChar.put("-..", 'D');
        morseAChar.put(".", 'E');
        morseAChar.put("..-.", 'F');
        morseAChar.put("--.", 'G');
        morseAChar.put("....", 'H');
        morseAChar.put("..", 'I');
        morseAChar.put(".---", 'J');
        morseAChar.put("-.-", 'K');
        morseAChar.put(".-..", 'L');
        morseAChar.put("--", 'M');
        morseAChar.put("-.", 'N');
        morseAChar.put("---", 'O');
        morseAChar.put(".--.", 'P');
        morseAChar.put("--.-", 'Q');
        morseAChar.put(".-.", 'R');
        morseAChar.put("...", 'S');
        morseAChar.put("-", 'T');
        morseAChar.put("..-", 'U');
        morseAChar.put("...-", 'V');
        morseAChar.put(".--", 'W');
        morseAChar.put("-..-", 'X');
        morseAChar.put("-.--", 'Y');
        morseAChar.put("--..", 'Z');
        morseAChar.put("-----", '0');
        morseAChar.put(".----", '1');
        morseAChar.put("..---", '2');
        morseAChar.put("...--", '3');
        morseAChar.put("....-", '4');
        morseAChar.put(".....", '5');
        morseAChar.put("-....", '6');
        morseAChar.put("--...", '7');
        morseAChar.put("---..", '8');
        morseAChar.put("----.", '9');
        String resultado= decodeMorsePhrase(oracion, morseAChar);
        System.out.println(resultado);
        return resultado;
    }
    public static String decodeMorsePhrase(String oracion, Map<String, Character> morseAChar) {
        String[] palabrasMorse = oracion.split("  ");
        String fraseCodificada = "";
        for (String palabraMorse : palabrasMorse) {
            String[] caracteresMorse = palabraMorse.split(" ");
            String palabraCodificada = "";
            for (String caracterMorse : caracteresMorse) {
                Character caracterCodificado = morseAChar.get(caracterMorse);
                if (caracterCodificado != null) {
                    palabraCodificada += caracterCodificado;                }
            }
            fraseCodificada += palabraCodificada + " ";
        }
        return fraseCodificada.trim().toUpperCase();
    }
    @GetMapping("/oracionAMorse")
    public String CaracterAMorse(@RequestParam String oracion){
        List<String> caracteres = List.of("A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K"
                , "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "1", "2", "3"
                , "4", "5", "6", "7", "8", "9", "0", "?", ".", ",", "!", " ");
        List<String> morseCodigo = List.of(
                ".- ", "-... ", "-.-. ", "-.. ", ". ", "..-. ", "--. ", ".... ", ".. ", ".--- ",
                "-.- ", ".-.. ", "-- ", "-. ", "--- ", ".--. ", "--.- ", ".-. ", "... ", "-", "..- ","...- ",
                ".-- ", "-..- ", "-.-- ", "--.. ", ".---- ", "..--- ", "...-- ", "....- ", "..... ", "-.... ",
                "--... ", "---.. ", "----. ", "----- ", "..--..", ".-.-.-", "--..--", "-.-.--", "  ");
        Map<String, String> palToMorse = new LinkedHashMap<>();
        String resultado = "";
        String character = null;
        for (int i = 0; i < caracteres.size(); i++) {
            palToMorse.put(caracteres.get(i), morseCodigo.get(i));
        }
        for (int x = 0; x < oracion.length(); x++) {
            character = String.valueOf(oracion.charAt(x));
            try {
                resultado = resultado.concat(palToMorse.get(character.toUpperCase()));
            } catch (Exception e) {
                resultado = resultado.concat(character.toLowerCase());
            }
        }
        return resultado;
    }
    @GetMapping("/{numero}")
    public String obtenerNumeroRomano(@PathVariable int numero) {
        if (numero < 1 || numero > 4999) {
            return "Error: El número debe estar entre 1 y 4999.";
        }
        return convertirARomano(numero);
    }
    public String convertirARomano(int numero) {
        String[] miles = {"", "M", "MM", "MMM", "MMMM"};
        String[] centenas = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] decenas = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] unidades = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

        return miles[numero / 1000] +
                centenas[(numero % 1000) / 100] +
                decenas[(numero % 100) / 10] +
                unidades[numero % 10];
    }
    @GetMapping("/name/{name}")
    public String muestraNombre (@PathVariable String name){
        int resultado = 4*5;
        if(resultado <19) {
            return "Hola señor: " + name;
        }
        else
            return "Adios " + name;
    }
}
