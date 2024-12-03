package com.mercadolibre;

import com.mercadolibre.series.Serie2Progresiva;
import com.mercadolibre.series.Serie3Progresiva;
import com.mercadolibre.series.SerieProgresiva;

public class Main {
    public static void main(String[] args) {
        SerieProgresiva serie = new Serie2Progresiva();
        System.out.println(serie.siguiente());
        System.out.println(serie.siguiente());
        System.out.println(serie.siguiente());
        System.out.println(serie.siguiente());
        serie.establecerInicial(1);

        System.out.println(serie.siguiente());
        System.out.println(serie.siguiente());
        System.out.println(serie.siguiente());
        System.out.println(serie.siguiente());

        serie = new Serie3Progresiva();

        System.out.println(serie.siguiente());
        System.out.println(serie.siguiente());
        System.out.println(serie.siguiente());
        System.out.println(serie.siguiente());
    }
}
