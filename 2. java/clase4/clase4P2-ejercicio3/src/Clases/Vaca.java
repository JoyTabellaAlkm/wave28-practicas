package Clases;

import Interfaces.IHerviboro;

public class Vaca extends Animal implements IHerviboro {
    public Vaca(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonid() {
        System.out.println("MUUUU");
    }

    @Override
    public void comerHierba() {
        System.out.println("Ñami ñami pastito");
    }
}
