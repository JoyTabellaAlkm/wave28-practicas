public class Gato extends Animal implements ICarnivoro {

    public Gato() {
    }

    @Override
    public String hacerSonido() {
        return "miau";
    }

    @Override
    public String comerCarne() {
        return "El gato esta comiendo Carne";
    }
}
