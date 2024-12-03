package com.mercadolibre;

public class Vaca extends Animal implements Herviboro {

    public Vaca(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Muu Muu");
    }

    @Override
    public void comerHierba() {
        System.out.println(getNombre() + " comiendo pasto...");
    }

}
