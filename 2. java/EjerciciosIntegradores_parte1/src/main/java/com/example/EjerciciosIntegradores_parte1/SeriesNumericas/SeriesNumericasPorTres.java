package com.example.EjerciciosIntegradores_parte1.SeriesNumericas;

import java.util.ArrayList;
import java.util.List;

public class SeriesNumericasPorTres extends Prototipo{
    private List<Integer> serieNumerica;

    public SeriesNumericasPorTres(int valorInicial) {
        super(valorInicial);
        this.serieNumerica = new ArrayList<>();
    }

    @Override
    public void devuelveValorSiguiente() {
        if(serieNumerica.isEmpty()){
            serieNumerica.add(super.getValorInicial()+3);
        } else {
            serieNumerica.add(serieNumerica.get(serieNumerica.size()-1)+3);
        }
    }

    @Override
    public void reiniciarSerie() {
        serieNumerica.clear();
    }
}
