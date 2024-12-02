package Modelo;

import Interfaces.Carnivoro;
import Interfaces.Hervivoro;

public class Vaca extends Animal implements Hervivoro {

    @Override
    public void emitirSonido() {
        System.out.println("Muuu");
    }

    @Override
    public void comer() {
        comerHierba();
    }

    @Override
    public void comerHierba() {
        System.out.println("Comer hierba");
    }
}
