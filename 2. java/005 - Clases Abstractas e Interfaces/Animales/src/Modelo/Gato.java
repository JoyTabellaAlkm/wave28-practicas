package Modelo;

import Interfaces.Carnivoro;

public class Gato extends Animal implements Carnivoro {
    @Override
    public void comerCarne() {
        System.out.println("Comer atun");
    }

    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comer() {
    comerCarne();
    }
}
