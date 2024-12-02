package com.company;

public class Vaca extends Animal{

    public Vaca(boolean carnivoro) {
        super(carnivoro);
    }

    @Override
    public void emitirSonido() {
        System.out.println("mu");
    }
}
