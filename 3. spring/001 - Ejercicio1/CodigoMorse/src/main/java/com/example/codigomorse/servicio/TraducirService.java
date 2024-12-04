package com.example.codigomorse.servicio;

import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class TraducirService {
    Map<String, String> morseToTexto = new HashMap<String, String>() {{
        put(".-", "A");
        put("-...", "B");
        put("-.-.", "C");
        put("-..", "D");
        put(".", "E");
        put("..-.", "F");
        put("--.", "G");
        put("....", "H");
        put("..", "I");
        put(".---", "J");
        put("-.-", "K");
        put(".-..", "L");
        put("--", "M");
        put("-.", "N");
        put("---", "O");
        put(".--.", "P");
        put("--.-", "Q");
        put(".-.", "R");
        put("...", "S");
        put("-", "T");
        put("..-", "U");
        put("...-", "V");
        put(".--", "W");
        put("-..-", "X");
        put("-.--", "Y");
        put("--..", "Z");
        put("-----", "0");
        put(".----", "1");
        put("..---", "2");
        put("...--", "3");
        put("....-", "4");
        put(".....", "5");
        put("-....", "6");
        put("--...", "7");
        put("---..", "8");
        put("----.", "9");
        put(".-.-.-", ".");
        put("--..--", ",");
        put("..--..", "?");
        put("-.-.--", "!");
        put("-....-", "-");
        put(".----.", "'");
        put("-..-.", "/");
        put("-.--.", "(");
        put("-.--.-", ")");
        put(".-.-.", "+");
        put("-...-", "=");
        put(".-..-.", "\"");
        put("...-..-", "$");
        put(".--.-.", "@");
        put("  ", " ");// Para agregar espacios entre palabras
    }};
    public String decodificarPalabra(String codigo) {

        List<String> traducido = new ArrayList<>();
        Arrays.stream(codigo.split(" ")).forEach(p -> {
            System.out.println(morseToTexto.get(p));
            traducido.add(morseToTexto.get(p));
        });

        return traducido.stream().collect(Collectors.joining(""));
    }

    public List<String> decodificarPalabras(String codigo) {
        List<String> palabrasDecodificadas = new ArrayList<>();
        if (codigo.contains("   ")) {
            String[] palabras = codigo.split("   ");
            Arrays.stream(palabras).forEach(p -> {
                palabrasDecodificadas.add(decodificarPalabra(p));
            });
            return palabrasDecodificadas;
        }
        palabrasDecodificadas.add(decodificarPalabra(codigo));
        return palabrasDecodificadas;
    }
    public String codificarPalabras(String texto){
        Map<String, String> textoToMorse = new HashMap<String, String>();
        morseToTexto.forEach((i,value)-> textoToMorse.put(value,i));
        String palabraCodificada = "";

        //Codifica cada caracter
        for(int i = 0; i< texto.length(); i++){
            System.out.println(textoToMorse.get(String.valueOf(texto.charAt(i))));
            palabraCodificada += textoToMorse.get(String.valueOf(texto.charAt(i)));

            //Para agregar espacios entre letras
            if(!String.valueOf(texto.charAt(i)).equals(" ")){
                palabraCodificada+=" ";
            }
        }
        return palabraCodificada;
    }

}
