public class Perro extends Animal implements ICarnivoro{

    public Perro() {
    }

    @Override
    public String hacerSonido() {
        return "guau";
    }

    @Override
    public String comerCarne() {
        return "El perro esta comiendo Carne";
    }
}
