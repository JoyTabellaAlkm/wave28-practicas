package com.bootcamp.ejercicio_3.classes;

import com.bootcamp.ejercicio_3.interfaces.ICarnivoro;

public class Gato extends Animal implements ICarnivoro {
    public Gato() {
    }

    @Override
    public void emitirSonido() {
        System.out.println("miau miau");
    }

    @Override
    public void comer() {
        comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("Rica Carne");
    }
}
