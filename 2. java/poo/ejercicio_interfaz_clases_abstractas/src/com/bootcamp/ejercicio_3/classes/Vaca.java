package com.bootcamp.ejercicio_3.classes;

import com.bootcamp.ejercicio_3.interfaces.IHerviboro;

public class Vaca extends Animal implements IHerviboro {
    public Vaca() {
    }
    @Override
    public void comer() {
        comerHierba();
    }

    @Override
    public void emitirSonido() {
        System.out.println("muuuuuuuu");
    }
    @Override
    public void comerHierba() {
        System.out.println("Rica Hierba");
    }
}
