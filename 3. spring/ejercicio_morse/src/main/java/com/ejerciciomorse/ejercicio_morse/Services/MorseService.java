package com.ejerciciomorse.ejercicio_morse.Services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class MorseService {

    private Map<String, String> morseDic = new HashMap<>() {
        {
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
            put("-.", "K");
            put(".-..", "L");
            put("--", "M");
            put("-.-", "N");
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
            put("", " ");

        }
    };

    public String morseATexto(@RequestParam String morse) {
        StringBuilder resultadoTexto = new StringBuilder();
        String[] letras = morse.split(" "); // "a   b" = ["a", "", "b"]
        Arrays.stream(letras).forEach(l -> resultadoTexto.append(macheoDeLetras(l)));
        return resultadoTexto.toString();
    }
    public String textoAMorse(@RequestParam String morse) {
        StringBuilder resultadoTexto = new StringBuilder();
        String[] letras = morse.split("");
        Arrays.stream(letras).forEach(p -> {
            if (p.equals(" ")){
                resultadoTexto.append("   ");
            }else {
                resultadoTexto.append(macheoDeMorse(p)).append(" ");
            }
        });
        return resultadoTexto.toString();
    }

    private String macheoDeLetras(String letraMorse) {
        return morseDic.get(letraMorse);
    }
    private String macheoDeMorse(String letra) {
        return morseDic.entrySet().stream().filter(x->x.getValue().equals(letra)).findFirst().get().getKey();
    }
}