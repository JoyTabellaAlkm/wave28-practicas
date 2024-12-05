package com.codigoMorse.morseALetras.service;

import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

@Service
public class CodigoMorseService {
    public String descifrarMensaje(String mensaje){
        Map<String, Character> diccionario = new HashMap<>();
        StringBuilder mensajeDescifrado = new StringBuilder();

        // Letras
        diccionario.put(".-", 'A');
        diccionario.put("-...", 'B');
        diccionario.put("-.-.", 'C');
        diccionario.put("-..", 'D');
        diccionario.put(".", 'E');
        diccionario.put("..-.", 'F');
        diccionario.put("--.", 'G');
        diccionario.put("....", 'H');
        diccionario.put("..", 'I');
        diccionario.put(".---", 'J');
        diccionario.put("-.-", 'K');
        diccionario.put(".-..", 'L');
        diccionario.put("--", 'M');
        diccionario.put("-.", 'N');
        diccionario.put("---", 'O');
        diccionario.put(".--.", 'P');
        diccionario.put("--.-", 'Q');
        diccionario.put(".-.", 'R');
        diccionario.put("...", 'S');
        diccionario.put("-", 'T');
        diccionario.put("..-", 'U');
        diccionario.put("...-", 'V');
        diccionario.put(".--", 'W');
        diccionario.put("-..-", 'X');
        diccionario.put("-.--", 'Y');
        diccionario.put("--..", 'Z');

        // Números
        diccionario.put("-----", '0');
        diccionario.put(".----", '1');
        diccionario.put("..---", '2');
        diccionario.put("...--", '3');
        diccionario.put("....-", '4');
        diccionario.put(".....", '5');
        diccionario.put("-....", '6');
        diccionario.put("--...", '7');
        diccionario.put("---..", '8');
        diccionario.put("----.", '9');

        String[] palabras = mensaje.split("   ");


        for (int i=0; i<palabras.length; i++){
            String[] letrasDePalabra = palabras[i].split(" ");
            for (int j=0; j<letrasDePalabra.length; j++){
                mensajeDescifrado.append(diccionario.get(letrasDePalabra[j]));
            }
            mensajeDescifrado.append(" ");
        }
        return mensajeDescifrado.toString();
    }
}
