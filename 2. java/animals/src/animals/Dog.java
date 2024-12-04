package animals;

public class Dog extends Animal implements IEat {

    @Override
    public void emitSound() {
        System.out.println("Guau guau guau");
    }

    @Override
    public void eat() {
        System.out.println("Perro comiendo carne");
    }
}
