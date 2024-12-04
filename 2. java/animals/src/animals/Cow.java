package animals;

public class Cow extends Animal implements IEat{

    @Override
    public void emitSound() {
        System.out.println("Muu muu muu");
    }

    @Override
    public void eat() {
        System.out.println("Vaca comiendo hierba");
    }
}
