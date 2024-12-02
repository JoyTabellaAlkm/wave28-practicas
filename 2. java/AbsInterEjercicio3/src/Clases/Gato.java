package Clases;

import Interfaces.Carnivoro;

public class Gato extends Animal implements Carnivoro {
    @Override
    public void hacerRuido() {
        System.out.println("miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Come carne");
    }
}
