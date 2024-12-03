package com.mercadolibre;

public class Gato extends Animal implements Carnivoro {

    public Gato(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Miau miau");
    }

    @Override
    public void comerCarne() {
        System.out.println(getNombre() + " comiendo carne...");
    }

}
