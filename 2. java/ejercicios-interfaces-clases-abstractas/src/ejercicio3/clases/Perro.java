package ejercicio3.clases;

import ejercicio3.interfaces.ICarnivoro;

public class Perro extends Animal implements ICarnivoro {
    public Perro() {
        super("Perro");
    }

    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }

    @Override
    public void comerCarne() {
        System.out.println("El perro come carne");
    }

    @Override
    public void comerAnimal(Animal animal) {
        System.out.println("El perro esta comiendo al animal " + animal.getEspecie());
    }
}
