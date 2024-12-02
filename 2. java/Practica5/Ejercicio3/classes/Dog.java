package classes;

import interfaces.ICarnivore;

public class Dog extends Animal implements ICarnivore {
    @Override
    public void eating() {
        eatingMeat();
    }

    public Dog(){
        this.setSound("WOOF!");
    }

    @Override
    public void eatingMeat() {
        System.out.println("Mmm roast beef...");
    }
}