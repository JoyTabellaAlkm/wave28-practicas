package Clases;

import Interfaces.Hervivoro;

public class Vaca extends Animal implements Hervivoro {
    @Override
    public void hacerRuido() {
        System.out.println("Muu");
    }

    @Override
    public void comerVerdura() {
        System.out.println("Come verdura");
    }
}
