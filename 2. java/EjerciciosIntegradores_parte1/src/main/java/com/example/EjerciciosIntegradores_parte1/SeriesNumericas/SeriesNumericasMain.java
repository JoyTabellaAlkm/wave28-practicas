package com.example.EjerciciosIntegradores_parte1.SeriesNumericas;

public class SeriesNumericasMain {
    public static void main(String[] args) {
        SeriesNumericasPorDos serieXDos = new SeriesNumericasPorDos(1);
        serieXDos.devuelveValorSiguiente();
        serieXDos.devuelveValorSiguiente();
        serieXDos.devuelveValorSiguiente();
        serieXDos.devuelveValorSiguiente();
        serieXDos.getSerieNumerica().stream().forEach(System.out::println);

    }
}
