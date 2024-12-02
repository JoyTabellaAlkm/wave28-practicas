package ejercicio3.clases;

import ejercicio3.interfaces.ICarnivoro;

public class Gato extends Animal implements ICarnivoro {
    public Gato() {
        super("Gato");
    }

    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public void comerCarne() {
        System.out.println("El gato come carne");
    }

    @Override
    public void comerAnimal(Animal animal) {
        System.out.println("El gato esta comiendo al animal " + animal.getEspecie());
    }
}
