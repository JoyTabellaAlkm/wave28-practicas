public class Gato extends Animal implements ICarnivoro {
    public Gato() {
    }

    @Override
    public void emitirSonido() {
        System.out.println("Miau");
    }

    @Override
    public String comerCarne() {
        return "Gato comiendo carne...";
    }
}
