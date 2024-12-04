package Ejercicios.traduccir_morse.services;
import Ejercicios.traduccir_morse.models.ModeloMapeo;
import java.util.HashMap;
import java.util.Map;

public class CodigoMorseService {
    private Map<String,Character> morseMap;
    private Map<Character,String> oracionMap;
    public CodigoMorseService() {
        this.morseMap = ModeloMapeo.getMorseLetraMap();
        this.oracionMap = ModeloMapeo.getOracionCodeMap();
    }

    public String morseAOracion(String morse){
        StringBuilder resultado = new StringBuilder();
        String[] palabras = morse.split("   ");

        for (String palabra : palabras) {
            String[] letras = palabra.split(" ");
            for (String letra : letras) {
                char caracter = morseMap.get(letra);
                resultado.append(caracter);
            }
            resultado.append(" ");
        }
        return resultado.toString().trim();
    }

    public String oracionAMorse(String oracion){
        StringBuilder codigoMorse = new StringBuilder();

        for (char c : oracion.toUpperCase().toCharArray()) {
            if (oracionMap.containsKey(c)) {
                codigoMorse.append(oracionMap.get(c)).append(" ");
            } else {
                codigoMorse.append("? ");
            }
        }
        return codigoMorse.toString().trim();
    }
    
    
}
