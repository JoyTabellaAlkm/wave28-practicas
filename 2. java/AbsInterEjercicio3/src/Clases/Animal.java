package Clases;

import Interfaces.Carnivoro;
import Interfaces.Hervivoro;

public abstract class Animal {
    public abstract void hacerRuido();

    public static void comerAnimal(Animal animal) {
        if (animal instanceof Carnivoro) {
            ((Carnivoro) animal).comerCarne();
        } else {
            ((Hervivoro) animal).comerVerdura();
        }
    }
}
