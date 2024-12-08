package models;

public class Perro extends Animal {

    public Perro() {
        this.gustoAlimenticio = "Carnivoro";
    }

    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }
}
