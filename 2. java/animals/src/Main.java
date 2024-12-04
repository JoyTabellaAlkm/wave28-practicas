import animals.Animal;
import animals.Cat;
import animals.Cow;
import animals.Dog;

public class Main {
    public static void main(String[] args) {
        Dog dog = new Dog();
        Cat cat = new Cat();
        Cow cow = new Cow();

        dog.emitSound();
        dog.eat();

        cat.emitSound();
        cat.eat();

        cow.emitSound();
        cow.eat();

        Animal.eatAnimal(cat);
        Animal.eatAnimal(cow);
    }
}