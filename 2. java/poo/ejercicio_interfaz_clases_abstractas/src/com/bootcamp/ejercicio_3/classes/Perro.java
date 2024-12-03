package com.bootcamp.ejercicio_3.classes;

import com.bootcamp.ejercicio_3.interfaces.ICarnivoro;

public class Perro extends Animal implements ICarnivoro {
    public Perro() {
    }

    @Override
    public void emitirSonido() {
        System.out.println("guau guau");
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
