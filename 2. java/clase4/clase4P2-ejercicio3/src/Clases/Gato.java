package Clases;

import Interfaces.ICarnivoro;

public class Gato extends Animal implements ICarnivoro {
    public Gato(String nombre) {
        super(nombre);
    }

    @Override
    public void comerCarne() {
        System.out.println("Ñami ñami pollito");
    }

    @Override
    public void emitirSonid() {
        System.out.println("MIAU MIAU");
    }
}
