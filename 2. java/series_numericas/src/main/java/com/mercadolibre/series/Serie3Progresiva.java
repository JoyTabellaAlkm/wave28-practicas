package com.mercadolibre.series;

public class Serie3Progresiva extends SerieProgresiva {

    @Override
    public Integer siguiente() {
        acumulado += 3;
        return acumulado;
    }

}
