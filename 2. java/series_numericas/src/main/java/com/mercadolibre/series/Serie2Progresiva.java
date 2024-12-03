package com.mercadolibre.series;

public class Serie2Progresiva extends SerieProgresiva {

    @Override
    public Integer siguiente() {
        acumulado += 2;
        return acumulado;
    }

}
