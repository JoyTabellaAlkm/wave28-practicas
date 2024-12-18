public class Perro extends Animal implements ICarnivoro{
    @Override
    public void sonido() {
        System.out.println("Guau, Guau, Guau..");
    }

    @Override
    public void comerCarne() {
        System.out.println("Comiendo carne.");
    }
}
