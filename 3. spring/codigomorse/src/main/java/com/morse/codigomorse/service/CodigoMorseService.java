package com.morse.codigomorse.service;

import lombok.NoArgsConstructor;
import java.util.*;

@NoArgsConstructor
public class CodigoMorseService {
    private static Map<String,Character> morseDic = inicializarDiccionario();

    public String convertirMensaje(String morse){
        String[] divisionMorse = morse.split("   ");
        StringBuilder desencriptedMessage = new StringBuilder();


        for(String m: divisionMorse){
            String[] letras = m.split(" ");
            for (String letra: letras){
                desencriptedMessage.append(morseDic.get(letra));
            }
            desencriptedMessage.append(" ");
        };
        return desencriptedMessage.toString();
    }

    public static Map<String, Character> inicializarDiccionario(){
        Map<String, Character> morseToText = new HashMap<>();

        // Letras
        morseToText.put(".-", 'A');
        morseToText.put("-...", 'B');
        morseToText.put("-.-.", 'C');
        morseToText.put("-..", 'D');
        morseToText.put(".", 'E');
        morseToText.put("..-.", 'F');
        morseToText.put("--.", 'G');
        morseToText.put("....", 'H');
        morseToText.put("..", 'I');
        morseToText.put(".---", 'J');
        morseToText.put("-.-", 'K');
        morseToText.put(".-..", 'L');
        morseToText.put("--", 'M');
        morseToText.put("-.", 'N');
        morseToText.put("---", 'O');
        morseToText.put(".--.", 'P');
        morseToText.put("--.-", 'Q');
        morseToText.put(".-.", 'R');
        morseToText.put("...", 'S');
        morseToText.put("-", 'T');
        morseToText.put("..-", 'U');
        morseToText.put("...-", 'V');
        morseToText.put(".--", 'W');
        morseToText.put("-..-", 'X');
        morseToText.put("-.--", 'Y');
        morseToText.put("--..", 'Z');

        // Números
        morseToText.put("-----", '0');
        morseToText.put(".----", '1');
        morseToText.put("..---", '2');
        morseToText.put("...--", '3');
        morseToText.put("....-", '4');
        morseToText.put(".....", '5');
        morseToText.put("-....", '6');
        morseToText.put("--...", '7');
        morseToText.put("---..", '8');
        morseToText.put("----.", '9');

        return morseToText;
    }
}
