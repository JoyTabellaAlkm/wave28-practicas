package Clases;

import Interfaces.ICarnivoro;

public class Perro extends Animal implements ICarnivoro {
    public Perro(String nombre) {
        super(nombre);
    }

    @Override
    public void comerCarne() {
        System.out.println("Ñami ñami pollito");
    }

    @Override
    public void emitirSonid() {
        System.out.println("WAW WAW");
    }
}
