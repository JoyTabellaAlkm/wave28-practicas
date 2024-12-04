package org.example;
public class Main {
    public static void main(String[] args) {
        Prototipo valor1 = new Prototipo(1, 1);
        System.out.println(valor1.valorSiguiente());;
        System.out.println(valor1.valorSiguiente());;
        System.out.println("");
        System.out.println(valor1.reinciarSerie());
        System.out.println(valor1.reiniciarSerieConOtroValor(5));
        System.out.println(valor1.valorSiguiente());;

    }

}