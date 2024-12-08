package models;

public class Vaca extends Animal{

    public Vaca() {
        this.gustoAlimenticio = "Herviboro";
    }

    @Override
    public void emitirSonido() {
        System.out.println("Muuuuu");
    }
}
