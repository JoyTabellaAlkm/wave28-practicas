package com.mercadolibre.series;

public abstract class SerieProgresiva {

    protected Integer valorInicial = 0;
    protected Integer acumulado = 0;

    public abstract Integer siguiente();

    public final void reiniciarSerie() {
        acumulado = 0;
    }

    public final void establecerInicial(Integer inicial) {
        valorInicial = inicial;
        acumulado = inicial;
    }

}
