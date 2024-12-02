package com.company;

public class Main {

    public static void main(String[] args) {

        Animal perro = new Perro(true);
        Animal gato = new Gato(true);
        Animal vaca = new Vaca(false);
        perro.emitirSonido();
        gato.emitirSonido();
        vaca.emitirSonido();
        perro.comer();
        gato.comer();
        vaca.comer();
    }
}
