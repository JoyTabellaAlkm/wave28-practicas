package ej3;

public class Vaca extends Animal implements IHerviboro {
    @Override
    public void emitirSonido() {
        System.out.println("muuu");
    }

    @Override
    public void comerHierba() {
        System.out.println("Comer pasto");
    }
}
