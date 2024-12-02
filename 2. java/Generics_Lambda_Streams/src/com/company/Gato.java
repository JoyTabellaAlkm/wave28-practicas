package com.company;

public class Gato extends Animal{
    public Gato(boolean carnivoro) {
        super(carnivoro);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }
}
