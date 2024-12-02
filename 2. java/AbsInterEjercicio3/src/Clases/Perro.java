package Clases;

import Interfaces.Carnivoro;

public class Perro extends Animal implements Carnivoro {
    @Override
    public void hacerRuido() {
        System.out.println("guau guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("Come carne");
    }
}
