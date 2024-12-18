public class Gato extends Animal implements ICarnivoro {
    @Override
    public void sonido() {
        System.out.println("Miau, Miau, Miau...");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne");
    }
}
