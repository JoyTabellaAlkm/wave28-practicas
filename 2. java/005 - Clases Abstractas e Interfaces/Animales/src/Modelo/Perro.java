package Modelo;

import Interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro {
    @Override
    public void comerCarne() {
        System.out.println("Comer carne");
    }

    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }

    @Override
    public void comer() {
        comerCarne();
    }
}
