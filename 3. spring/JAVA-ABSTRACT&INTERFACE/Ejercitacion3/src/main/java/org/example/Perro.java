package org.example;

public class Perro extends Animal implements Carnivoro{

    @Override
    public void emitirSonido(){
        System.out.println("Guau");

    }

    @Override
    public void comerAnimal() {
        this.comerCarne();
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne");
    }
}
