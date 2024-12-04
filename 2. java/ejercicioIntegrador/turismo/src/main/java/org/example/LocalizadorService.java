package org.example;

import org.example.modelos.Localizador;

import java.util.List;
import java.util.stream.IntStream;

public class LocalizadorService {
    private List<Localizador> localizadores;
    public LocalizadorService(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

    public int cantidadLocalizadores(){
        return this.localizadores.size();
    }

    public int cantidadReservas(){
        return localizadores.stream()
                .flatMapToInt(x -> IntStream.of(x.getReservas().size()))
                .sum();

    }
}