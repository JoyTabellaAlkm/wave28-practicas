package com.morse.codigomorse.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CodigoMorseService {
    private static Map<String, Character> morseDic = inicializarDiccionario();
    private static Map<Character, String> LetrasDic = morseDic.entrySet()
            .stream()
            .collect(Collectors.toMap(
                    entry -> entry.getValue(),
                    entry -> entry.getKey()
            ));

    public CodigoMorseService(){};
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

    public String convertirMensajeALetras(String morse){

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

    public String convertirMensajeAMorse(String mensaje){
        mensaje.toUpperCase();
        String[] divisionMensaje = mensaje.split(" ");
        StringBuilder desencriptedMessage = new StringBuilder();


        for(String m: divisionMensaje){
            String[] letras = m.split("");
            for (String letra: letras){
                desencriptedMessage.append(LetrasDic.get(letra.charAt(0)));
                desencriptedMessage.append(" ");
            }
            desencriptedMessage.append("\u00A0\u00A0\u00A0");
        };
        return desencriptedMessage.toString();
    }

}
