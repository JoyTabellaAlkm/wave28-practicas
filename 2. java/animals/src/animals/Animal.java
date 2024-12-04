package animals;

public abstract class Animal {

    protected abstract void emitSound();

    public static void eatAnimal(IEat animal){
        animal.eat();
    };

}
