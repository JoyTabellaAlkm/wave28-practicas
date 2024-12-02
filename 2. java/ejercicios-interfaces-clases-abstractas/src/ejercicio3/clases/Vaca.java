package ejercicio3.clases;

import ejercicio3.interfaces.IHerbivoro;

public class Vaca extends Animal implements IHerbivoro {
    public Vaca() {
        super("Vaca");
    }

    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("La vaca come hierba");
    }
}
