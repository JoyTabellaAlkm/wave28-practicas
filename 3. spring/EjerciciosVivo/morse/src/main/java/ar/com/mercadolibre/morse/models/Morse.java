package ar.com.mercadolibre.morse.models;

import java.util.HashMap;
import java.util.Map;

public class Morse {
    Map<String, Character> listaLetras = new HashMap<>();

    // Construct
    public Morse(){
        poblarMapa();
    }

    // Populate Method
    public void poblarMapa(){
        listaLetras.put(".-", 'a');
        listaLetras.put("-...", 'b');
        listaLetras.put("-.-.", 'c');
        listaLetras.put("-..", 'd');
        listaLetras.put(".", 'e');
        listaLetras.put("..-.", 'f');
        listaLetras.put("--.", 'g');
        listaLetras.put("....", 'h');
        listaLetras.put("..", 'i');
        listaLetras.put(".---", 'j');
        listaLetras.put("-.", 'k');
        listaLetras.put(".-..", 'l');
        listaLetras.put("--", 'm');
        listaLetras.put("-.", 'n');
        listaLetras.put("---", 'o');
        listaLetras.put(".--.", 'p');
        listaLetras.put("--.-", 'q');
        listaLetras.put(".-.", 'r');
        listaLetras.put("...", 's');
        listaLetras.put("-", 't');
        listaLetras.put("..-", 'u');
        listaLetras.put("...-", 'v');
        listaLetras.put(".--", 'w');
        listaLetras.put("-..-", 'x');
        listaLetras.put("-.--", 'y');
        listaLetras.put("--..", 'z');
        listaLetras.put(".----", '1');
        listaLetras.put("..---", '2');
        listaLetras.put("...--", '3');
        listaLetras.put("....-", '4');
        listaLetras.put(".....", '5');
        listaLetras.put("-....", '6');
        listaLetras.put("--...", '7');
        listaLetras.put("---..", '8');
        listaLetras.put("----.", '9');
        listaLetras.put("-----", '0');
    }

    public Map<String, Character> getListaLetras() {
        return listaLetras;
    }
}
