package com.mercadolibre;

public class Perro extends Animal implements Carnivoro {

    public Perro(String nombre) {
        super(nombre);
    }

    @Override
    public void emitirSonido() {
        System.out.println("Guau Guau");
    }

    @Override
    public void comerCarne() {
        System.out.println(getNombre() + " comiendo carne...");
    }

}
