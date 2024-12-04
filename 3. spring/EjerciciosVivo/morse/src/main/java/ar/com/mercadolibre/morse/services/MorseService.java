package ar.com.mercadolibre.morse.services;

import ar.com.mercadolibre.morse.models.Morse;
import org.springframework.stereotype.Service;

@Service
public class MorseService {
    public String convertirMorse(String codigo_morse){
        String texto = "";
        Morse morse = new Morse();
        String[] palabras = codigo_morse.split("   ");

        for(String palabra : palabras){
            String[] letra = palabra.split(" ");
            for (String l : letra){
                if(morse.getListaLetras().containsKey(l)){
                    System.out.println(l);
                    texto += morse.getListaLetras().get(l);
                }
            }
            texto += " ";
        }

        return texto;
    }
}
