package animals;

public class Cat extends Animal implements IEat {

    @Override
    public void emitSound() {
        System.out.println("Miau miau miau");
    }

    @Override
    public void eat() {
        System.out.println("Gato comiendo carne");
    }
}
