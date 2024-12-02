import Entities.*;
import Interfaces.ICarnivore;
import Interfaces.IHerbivore;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat();
        Dog dog = new Dog();
        Cow cow = new Cow();

        cat.emitSound();
        dog.emitSound();
        cow.emitSound();


        eating(cat); // Why would the object be referencing itself?
        eating(dog); // This is all sorts of wrong!
        eating(cow); // See if there is another way of doing it

    }

    public static void eating(Animal animal){
        animal.eating();
    }

}
