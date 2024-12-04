package com.ar.mercadolibre.codigomorse.services;

import com.ar.mercadolibre.codigomorse.models.CodigoMorse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MorseTraductorServiceImpl implements IMorseTraductorService{

    private CodigoMorse codigoMorse;

    public MorseTraductorServiceImpl() {
        this.codigoMorse = new CodigoMorse();
    }


    @Override
    public String devolverPalabra(String codigoMorse) {
        String[] arrayPalabras = codigoMorse.split("   ");
        List<List<String>> letras = new ArrayList<>();

        for(String palabra: arrayPalabras) {
           letras.add((Arrays.stream(palabra.split(" ")).toList()));
        }

        StringBuilder textoTraducido = new StringBuilder();

        letras.stream().forEach(palabras -> {
            palabras.stream().forEach(letra -> textoTraducido.append(this.codigoMorse.getCodigoMorse().get(letra)));
            textoTraducido.append(" ");
        });

        return textoTraducido.toString();
    }
}
