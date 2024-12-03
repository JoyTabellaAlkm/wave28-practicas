package com.example.EjerciciosIntegradores_parte1.SeriesNumericas;

import java.util.ArrayList;
import java.util.List;

public class SeriesNumericasPorDos extends Prototipo{

    private List<Integer> serieNumerica;

    public SeriesNumericasPorDos(int valorInicial) {
        super(valorInicial);
        this.serieNumerica = new ArrayList<>();
    }

    public List<Integer> getSerieNumerica() {
        return serieNumerica;
    }

    public void setSerieNumerica(List<Integer> serieNumerica) {
        this.serieNumerica = serieNumerica;
    }

    @Override
    public void devuelveValorSiguiente() {
        if(serieNumerica.isEmpty()){
            serieNumerica.add(super.getValorInicial()+2);
        } else {
            serieNumerica.add((serieNumerica.get(serieNumerica.size()-1) +2));
        }
    }

    @Override
    public void reiniciarSerie() {
        serieNumerica.clear();
    }
}
