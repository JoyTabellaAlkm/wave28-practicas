public class Perro extends Animal implements ICarnivoro {
    public Perro() {
    }

    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }

    @Override
    public String comerCarne() {
        return "Perro comiendo carne...";
    }
}
