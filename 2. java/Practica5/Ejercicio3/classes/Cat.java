package classes;

import interfaces.ICarnivore;

public class Cat extends Animal implements ICarnivore {
    @Override
    public void eating() {
        eatingMeat();
    }

    public Cat(){
        this.setSound("MEOW!");
    }

    @Override
    public void eatingMeat() {
        System.out.println("Om nom nom... tuna...");
    }


}