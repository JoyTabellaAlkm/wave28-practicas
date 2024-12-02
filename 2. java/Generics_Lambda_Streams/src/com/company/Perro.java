package com.company;

public class Perro extends Animal {

    public Perro(boolean carnivoro) {
        super(carnivoro);
    }

    @Override
    public void emitirSonido() {
        System.out.println("guao");
    }


}
