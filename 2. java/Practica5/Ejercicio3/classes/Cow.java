package classes;

import interfaces.IHerbivore;

public class Cow extends Animal implements IHerbivore {
    @Override
    public void eating() {
        eatingHerbs();
    }

    public Cow() {
        this.setSound("MOO!");
    }

    @Override
    public void eatingHerbs() {
        System.out.println("Om nom nom, grass...");
    }
}