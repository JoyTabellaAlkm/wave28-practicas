package models;

public class Gato extends Animal{

    public Gato() {
        this.gustoAlimenticio = "Carnivoro";
    }

    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }
}
