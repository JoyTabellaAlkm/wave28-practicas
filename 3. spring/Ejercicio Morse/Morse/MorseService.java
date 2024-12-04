package com.bootcamp.Morse;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class MorseService {

    public String decodificar(String mensaje){

        Map<String,String> codigoMorse = new HashMap<>();
        codigoMorse.put("   ", " ");
        codigoMorse.put(".-","A");
        codigoMorse.put("-...","B");
        codigoMorse.put("-.-.","C");
        codigoMorse.put("-..","D");
        codigoMorse.put(".","E");
        codigoMorse.put("..-.","F");
        codigoMorse.put("--.","G");
        codigoMorse.put("....","H");
        codigoMorse.put("..","I");
        codigoMorse.put(".---","J");
        codigoMorse.put("-.-","K");
        codigoMorse.put(".-..","L");
        codigoMorse.put("--","M");
        codigoMorse.put("-.","N");
        codigoMorse.put("---","O");
        codigoMorse.put(".--.","P");
        codigoMorse.put("--.-","Q");
        codigoMorse.put(".-.","R");
        codigoMorse.put("...","S");
        codigoMorse.put("-","T");
        codigoMorse.put("..-","U");
        codigoMorse.put("...-","V");
        codigoMorse.put(".--","W");
        codigoMorse.put("-..-","X");
        codigoMorse.put("-.--","Y");
        codigoMorse.put("--..","Z");
        codigoMorse.put(".----","1");
        codigoMorse.put("..---","2");
        codigoMorse.put("...--","3");
        codigoMorse.put("....-","4");
        codigoMorse.put(".....","5");
        codigoMorse.put("-....","6");
        codigoMorse.put("--...","7");
        codigoMorse.put("---..","8");
        codigoMorse.put("----.","9");
        codigoMorse.put("-----","0");
        codigoMorse.put("..--..","?");
        codigoMorse.put("-.-.--","!");
        codigoMorse.put(".-.-.-",".");
        codigoMorse.put("--..--",",");

        String[] palabrasMorse = mensaje.split("  ");
        System.out.println(palabrasMorse);
        StringBuilder decodificador = new StringBuilder();
        for (int i = 0; i< palabrasMorse.length; i++){
            String[] caracteresMorse = palabrasMorse[i].split(" ");
            System.out.println(caracteresMorse);
            for (int j = 0; j< caracteresMorse.length; j++){
                System.out.println(caracteresMorse[j]);
                boolean existe =codigoMorse.containsKey(caracteresMorse[j]);
                if(existe){
                    String key = codigoMorse.get(caracteresMorse[j]);
                    decodificador.append(key);
                }else{
                    decodificador.append(' ');
                }
            }
            System.out.println("");

        }
        return decodificador.toString();
    }
}
