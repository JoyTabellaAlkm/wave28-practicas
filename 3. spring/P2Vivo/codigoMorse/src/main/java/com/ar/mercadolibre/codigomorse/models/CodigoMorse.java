package com.ar.mercadolibre.codigomorse.models;

import java.util.HashMap;
import java.util.Map;

public class CodigoMorse {

    private Map<String, Character> codigoMorse = new HashMap<>();

    public CodigoMorse() {
        codigoMorse.put(".-", 'A');
        codigoMorse.put("-..." , 'B');
        codigoMorse.put("-.-.", 'C');
        codigoMorse.put("-..", 'D');
        codigoMorse.put(".", 'E');
        codigoMorse.put("..-.", 'F');
        codigoMorse.put("--.", 'G');
        codigoMorse.put("....", 'H');
        codigoMorse.put("..", 'I');
        codigoMorse.put(".---", 'J');
        codigoMorse.put("-.-", 'K');
        codigoMorse.put(".-..", 'L');
        codigoMorse.put( "--", 'M');
        codigoMorse.put("-.", 'N');
        codigoMorse.put("---", 'O');
        codigoMorse.put(".--.", 'P');
        codigoMorse.put("--.-", 'Q');
        codigoMorse.put(".-.", 'R');
        codigoMorse.put("...", 'S');
        codigoMorse.put("-", 'T');
        codigoMorse.put("..-", 'U');
        codigoMorse.put("...-", 'V');
        codigoMorse.put(".--", 'W');
        codigoMorse.put("-..-", 'X');
        codigoMorse.put("-.--", 'Y');
        codigoMorse.put("--..", 'Z');
        codigoMorse.put( "-----", '0');
        codigoMorse.put( ".----" , '1');
        codigoMorse.put("..---", '2');
        codigoMorse.put("...--", '3');
        codigoMorse.put("....-", '4');
        codigoMorse.put(".....",'5');
        codigoMorse.put("-....",'6');
        codigoMorse.put("--...",'7');
        codigoMorse.put("---..",'8');
        codigoMorse.put("----.",'9');
        codigoMorse.put("..--..",'?');
        codigoMorse.put("-.-.--",'!');
    }

    public Map<String, Character> getCodigoMorse() {
        return codigoMorse;
    }
}
