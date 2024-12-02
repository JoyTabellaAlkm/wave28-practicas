package Entities;

import Interfaces.ICarnivore;
import Interfaces.IHerbivore;

public abstract class Animal {

    // ATTRIBUTES
    private String sound;

    // METHODS
    public void emitSound(){
        System.out.println(sound);
    }

    public abstract void eating();

    // CONSTRUCTOR
    public Animal(){
    }

    // SETS & GETS

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
}
