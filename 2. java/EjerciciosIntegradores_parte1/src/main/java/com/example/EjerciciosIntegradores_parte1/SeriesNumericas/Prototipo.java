package com.example.EjerciciosIntegradores_parte1.SeriesNumericas;

public abstract class Prototipo {
    private Integer valorInicial;

    public Prototipo(int valorInicial) {
        this.valorInicial = valorInicial;
    }

    public int getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(int valorInicial) {
        this.valorInicial = valorInicial;
    }

    public abstract void devuelveValorSiguiente();
    public abstract void reiniciarSerie();

}
